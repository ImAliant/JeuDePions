package main.jeu;

/**
 * <b>Jeu est la classe représentant la partie d'un jeu de pion.</b>
 * <p>
 * Le jeu est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un plateau sur lequel la partie se déroule.</li>
 * <li> Un tableau de deux joueurs.</li>
 * </ul>
 * 
 * @see Plateau
 * @see Joueur
 * 
 * @author Alexandre, Aymen, Mouadh, Riad
 */
public class Jeu {

    /**
     * Le plateau où se déroule la partie.
     * 
     * @see Jeu#getP()
     */
    private Plateau p;

    /**
     * Le tableau de deux objets Joueur.
     * 
     * @see Jeu#getJoueurs()
     * 
     * @see Joueur
     */
    public static Joueur[] joueurs =new Joueur[2];
    
    /**
     * Constructeur Jeu.
     * <p>
     * A la construction d'un objet Jeu, le tableau est fixé avec les deux
     * objets Joueur mis en paramètre et un nouveau Plateau est initialisé.
     * </p>
     * @param j1
     *      Premier Joueur.
     * @param j2
     *      Deuxième Joueur.
     * 
     * @see Joueur
     * @see Plateau
     */
    public Jeu(Joueur j1, Joueur j2){
        joueurs[0] = j1;
        joueurs[1] = j2;
        p =new Plateau();
    }

    /**
     * Déroulement de la partie de jeu de pion. La partie continue jusqu'à
     * ce que un des joueurs aligne le nombre requis de pion.
     * 
     * @see Joueur
     */
    public void partie(){
        int vainqueur = -1;
        int tourJoueur = 0;
        int tour = 1;

        p.affichagePlateau();

        while(vainqueur == -1){
            System.out.println("Tour " + tour + ", Etat du plateau :");
            System.out.println();

            joueurs[tourJoueur].joue(p);
            p.affichagePlateau();


            if(p.victoire()){
                vainqueur = tourJoueur;
            }

            if(p.estPlein()){
                vainqueur = 3;
            }

            tourJoueur++;
            tourJoueur %= 2;
            tour++;

            for(int i = 0; i < p.getListKu().size(); i++){
                p.getListKu().get(i).score();
            }
            for(int i = 0; i < p.getCases().length; i++){
                for(int j = 0; j < p.getCases()[i].length; j++){
                    p.getCases()[i][j].score();
                }
            }
        }

        System.out.println("FIN DE PARTIE");
        p.affichagePlateau();
        if(vainqueur == 3){
            System.out.println("MATCH NUL");
        }
        else{
            String sNom = joueurs[vainqueur].getNom().toUpperCase();
            System.out.println(sNom + " A GAGNE LA PARTIE");
        }
    }

    /**
     * Retourne le plateau de la partie en cours.
     * @return Le plateau de la partie en cours.
     */
    public Plateau getP() {
        return p;
    }

    /**
     * Retourne le tableau de joueurs.
     * @return Le tableau de joueurs.
     */
    public Joueur[] getJoueurs() {
        return joueurs;
    }
}


