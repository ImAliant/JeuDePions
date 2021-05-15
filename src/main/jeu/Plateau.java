package main.jeu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <b>Plateau est la classe représentant le plateau où se déroule la partie d'un jeu de pion.</b>
 * <p>
 * Le plateau est caractérisé par les informations suivantes :
 * <ul>
 * <li>Un entier K correspondant à l'alignement requis pour gagné.</li>
 * <li>Un entier N, le nombre de colonnes du plateau.</li>
 * <li>Un entier M, le nombre de lignes du plateau.</li>
 * <li>Un tableau à deux dimensions de cases.</li>
 * <li>Une liste contenant l'ensemble des k-uplets du plateau.</li>
 * <li>Une chaîne de caractère correspondant au réponse de l'utilisateur.</li>
 * </ul>
 * 
 * @see Case
 * @see kuplet
 * 
 * @author Alexandre, Aymen, Mouadh, Riad
 */
public class Plateau {

    /**
     * L'alignement requis pour gagné la partie.
     * 
     * @see Plateau#getK()
     */
    private int K;

    /**
     * Le nombre de colonnes du plateau.
     * 
     * @see Plateau#getN()
     */
    private int N;

    /**
     * Le nombre de lignes du plateau.
     * 
     * @see Plateau#getM()
     */
    private int M;

    /**
     * Le tableau à deux dimensions de cases.
     * 
     * @see Plateau#getCases()
     * 
     * @see Case
     */
    private Case[][] cases;

    /**
     * La liste de l'ensemble des k-uplets.
     * 
     * @see Plateau#getListKu()
     * 
     * @see kuplet
     */
    private ArrayList<kuplet> listKu;

    /**
     * Une chaîne de caractère correspondant au réponse de l'utilisateur.
     * 
     * @see Plateau#getScan()
     */
    private String scan;

    private Scanner scanner =new Scanner(System.in);

    /**
     * Constructeur Plateau.
     * <p>
     * A la construction d'un objet Plateau, la méthode initJeu() est appelé ce qui
     * initialise le plateau pour la partie de jeu de pions.
     * </p>
     * 
     * @see Plateau#initJeu()
     */
    public Plateau(){
        initJeu();
    }

    /**
     * Initialise le plateau en fonction des choix de l'utilisateur.
     */
    void initJeu(){
        System.out.println("Souhaitez-vous jouer à un jeu prédéfini (1) ou choisir votre configuration de plateau (2) ? (1 ou 2)");
        String repChoix = scanner.nextLine();

        System.out.println();

        if(repChoix.equals("1")){
            // Initialisation du plateau
            boolean choixJeu = false;
            while(!choixJeu){
                System.out.println("Selection de jeu : Gomoku / Puissance4 / Morpion");
                scan = scanner.nextLine();
                if(scan.equals("Gomoku")){
                    K = 5;
                    N = 19;
                    M = 19;
                    choixJeu = true;
                }
                else if(scan.equals("Puissance4")){
                    K = 4;
                    N = 7;
                    M = 6;
                    choixJeu = true;
                }
                else if(scan.equals("Morpion")){
                    K = 3;
                    N = 3;
                    M = 3;
                    choixJeu = true;
                }
                else{
                    System.out.println("Ce jeu n'existe pas !");
                    choixJeu = false;
                }
            }
        }
        else if(repChoix.equals("2")){
            scan = "ConfigPerso";
            System.out.println("--CONFIGURATIONS PLATEAU--");
            
            boolean choixConfig = false;
            int repCol = 0;
            int repLig = 0;
            int repAlign = 0;

            while(!choixConfig){
                System.out.println("Nombres de colonnes ( min 3 ) :");
                repCol = scanner.nextInt();

                System.out.println();

                System.out.println("Nombres de lignes ( min 3 ) :");
                repLig = scanner.nextInt();

                System.out.println();

                System.out.println("Alignement requis pour la victoire ( min 3 ) :");
                repAlign = scanner.nextInt();

                System.out.println();

                if(repCol < 3 || repLig < 3 || repAlign < 3){
                    choixConfig = false;
                }
                else{
                    choixConfig = true;
                }
            }
            K = repAlign;
            N = repCol;
            M = repLig;
        }

        cases =new Case[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                cases[i][j] =new Case(0, i, j, null);
            } 
        }
        
        listKu =new ArrayList<kuplet>();
        initKupletPlateau(listKu);
        initKupletCases(this);
    }

    /**
     * Affiche l'ensemble des k-uplets du plateau.
     * @param listKu
     *      La liste des k-uplets du plateau.
     * 
     * @see kuplet
     */
    void afficheKuplets(ArrayList<kuplet> listKu){
        for(int i = 0; i < listKu.size(); i++){
            System.out.print("[");
            for(int loop = 0; loop < getK(); loop++){
                System.out.print(listKu.get(i).getC()[loop].getX() + "," + listKu.get(i).getC()[loop].getY() + " score : " + listKu.get(i).getC()[loop].getScore() + " | ");
            }
            System.out.print("]" + " score : " + listKu.get(i).getScore());
            System.out.println();
        } 
        System.out.println();
    }

    /**
     * Initialise les k-uplets du plateau.
     * @param listKu
     *      La liste où va être ajouté les k-uplets.
     * 
     * @see kuplet
     */
    void initKupletPlateau(ArrayList<kuplet> listKu){
        Case[] c =new Case[K];
        kuplet k;
        int loop = 0; 
        //Kuplets horizontaux
        for(int j = 0; j < M; j++){
            for(int i = 0; i <= N-K; i++){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                    i++;
                }
                loop = 0;
                i -= K;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
        //Kuplets verticaux
        for(int i = 0; i < N; i++){
            for(int j = 0; j <= M-K; j++){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                    j++;
                }
                loop = 0;
                j -= K;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
        //Kuplets HG-BD
        for(int i = 0; i <= N-K; i++){
            for(int j = 0; j <= M-K; j++){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                    i++;
                    j++;
                }
                loop = 0;
                i -= K;
                j -= K;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
        //Kuplets BG-HD
        for(int i = 0; i <= N-K; i++){
            for(int j = M-1; j >= K-1; j--){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                    i++;
                    j--;
                }
                loop = 0;
                i -= K;
                j += K;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
    }

    /**
     * Initialise la liste de k-uplets où se trouve la case.
     * @param p
     * 
     * @see kuplet
     * @see Case
     */
    void initKupletCases(Plateau p){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                cases[i][j].setLi(cases[i][j].initialisation(p));
            }
        }
    }

    /**
     * Affiche le plateau.
     */
    void affichagePlateau(){
        System.out.println();
        if(scan.equals("Gomoku") || scan.equals("ConfigPerso")){
            System.out.print("    ");
            char ascii = 65;
            int a = 65;
            for(int c = 65; c < a + N; c++){
                ascii = (char) c;
                String lettre = Character.toString(ascii);
                System.out.print(lettre + "  ");
            }
        }
        else if(scan.equals("Morpion")){
            System.out.print("    ");
            for(int i = 1; i <= N; i++)
                System.out.print(i + "  ");
        }
        else{
            System.out.print("  ");
            for(int i = 1; i <= N; i++)
                System.out.print(i + "  ");
        }
        System.out.println();
        if(scan.equals("Gomoku") || scan.equals("Morpion") || scan.equals("ConfigPerso"))
            System.out.print("  ");
        for (int loop = 0; loop < N + 2 + 2 * N; loop++)
			System.out.print('-');
        System.out.println();
        
        int compt = 1;
        if(scan.equals("Gomoku") || scan.equals("ConfigPerso")){
            for (int y = 0; y < M; y++) {
                System.out.print(compt);
                compt++;
                if(compt <= 10){
			        System.out.print(" |");
			        for (int x = 0; x < N; x++) {
			        	System.out.print(" " + cases[x][y].getEtat() + " ");
			        }
			        System.out.print('|');
                }
                else{
                    System.out.print('|');
			        for (int x = 0; x < N; x++) {
			        	System.out.print(" " + cases[x][y].getEtat() + " ");
			        }
			        System.out.print('|');
                }
                System.out.println();
		    }
        }
        else if(scan.equals("Puissance4")){
            for (int y = 0; y < M; y++) {
                System.out.print('|');
                for (int x = 0; x < N; x++) {
                    System.out.print(" " + cases[x][y].getEtat() + " ");
                }
                System.out.print('|');
                System.out.println();
            }
        }
        else if(scan.equals("Morpion")){
            for (int y = 0; y < M; y++) {
                System.out.print(compt);
                compt++;
                System.out.print(" |");
                for (int x = 0; x < N; x++) {
                    System.out.print(" " + cases[x][y].getEtat() + " ");
                }
                System.out.print('|');
                System.out.println();
            }
        }
        if(scan.equals("Gomoku") || scan.equals("Morpion") || scan.equals("ConfigPerso"))
            System.out.print("  ");
        for (int loop = 0; loop < N + 2 + 2 * N; loop++)
			System.out.print('-');
        System.out.println();
        System.out.println();
    }
  
    /**
     * A chaque tour de jeu, cherche si un des joueurs a gagné la partie.
     * @return True si un des joueurs a gagné.
     * 
     * @see Joueur
     */
    boolean victoire(){
        // Diagonales (cherche depuis la ligne du bas)
        for (int col = 0; col < N; col++) {
            // Première diagonale ( / )
            if (chercheAlignes(col, 0, 1, 1))
                return true;
            // Deuxième diagonale ( \ )
            if (chercheAlignes(col, 0, -1, 1))
                return true;
        }
  
        // Diagonales (cherche depuis les colonnes gauches et droites)
        for (int lig = 0; lig < M; lig++) {
            // Première diagonale ( / )
            if (chercheAlignes(0, lig, 1, 1))
                return true;
            // Deuxième diagonale ( \ )
            if (chercheAlignes(N - 1, lig, -1, 1))
                return true;
        }
		// --> verticale:
		for(int col = 0; col < N; col++){
            if(chercheAlignes(col, 0, 0, 1))
                return true;
        }
		// --> horizontale:
		for(int lig = 0; lig < M; lig++){
            if(chercheAlignes(0, lig, 1, 0))
                return true;
        }
        return false;
    }

    /**
     * Cherche si il y a un alignement de K cases de la même couleur.
     * 
     * @param currentCol  
     * @param currentLig   
     * @param dCol     
     * @param dLig
     *     
     * @return True si il y a un alignement de K cases de la même couleur.
     * 
     * @see Case
     */
    boolean chercheAlignes(int currentCol, int currentLig, int dCol, int dLig){
        int couleur = 0;
        int compteur = 0;

        while(currentCol >= 0 && currentCol < N && currentLig >= 0 && currentLig < M){
            if(cases[currentCol][currentLig].getIntEtat() != couleur){
                couleur = cases[currentCol][currentLig].getIntEtat();
                compteur = 1;
            }
            else{
                compteur++;
            }

            if(couleur != 0 && compteur == K){
                return true;
            }
            currentCol += dCol;
            currentLig += dLig;
        }
        return false;
    }
    
    /**
     * Recherche si le plateau est plein, c'est à dire qu'il n'y a plus de cases vide.
     * @return True si le plateau est plein.
     */
    public boolean estPlein(){
        int casesRestantes = N*M;
        for(int col = 0; col < N; col++){
            for(int lig = 0; lig < M; lig++){
                if(cases[col][lig].getIntEtat() != 0){
                    casesRestantes--;
                }
            } 
        }
        if(casesRestantes == 0){
            return true;
        }
        else return false;
    }

    /**
     * Retourne l'alignement requis.
     * @return L'alignement requis.
     */
    public int getK() {
        return K;
    }

    /**
     * Retourne le nombre de colonnes.
     * @return Le nombre de colonnes.
     */
    public int getN() {
        return N;
    }

    /**
     * Retourne le nombre de lignes.
     * @return Le nombre de lignes.
     */
    public int getM() {
        return M;
    }

    /**
     * Retourne le tableau à deux dimensions de cases.
     * @return Le tableau à deux dimensions de cases.
     */
    public Case[][] getCases() {
        return cases;
    }


    /**
     * Retourne la liste des k-uplets du plateau.
     * @return La liste des k-uplets du plateau.
     */
    public ArrayList<kuplet> getListKu() {
        return listKu;
    }

    /**
     * Retourne la réponse de l'utilisateur.
     * @return La réponse de l'utilisateur.
     */
    public String getScan() {
        return scan;
    }
}