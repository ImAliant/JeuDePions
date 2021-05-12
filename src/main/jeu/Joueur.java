package main.jeu;

/**
 * <b>Joueur est la classe représentant un joueur.</b>
 * <p>
 * Un joueur est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un nom.</li>
 * <li> Une couleur, correspondant à la couleur du pion.</li>
 * </ul>
 * Il y a deux types de Joueur :
 * <ul>
 * <li>Humain.</li>
 * <li>Ordinateur.</li>
 * </ul>
 * 
 * @see Humain
 * @see Ordinateur
 * 
 * @author Alexandre, Aymen, Mouadh, Riad
 */
public class Joueur {
    
    /**
     * Le nom du joueur.
     * 
     * @see Joueur#getNom()
     * @see Joueur#setNom(String)
     */
    private String nom;
    
    /**
     * La couleur du joueur.
     * 
     * @see Joueur#getCouleur()
     * @see Joueur#setCouleur(int)
     */
    private int couleur;

    /**
     * Constructeur Joueur.
     * <p>
     * A la construction d'un objet Joueur, le nom est fixé par l'utilisateur 
     * si c'est un Humain ou fixé à "L'ordinateur" si le Joueur est de type Ordinateur.
     * La couleur est fixé à 1 si le Joueur joue en premier ou 2 si il joue
     * en deuxième. 
     * </p>
     * @param nom
     *      Le nom du Joueur.
     * @param couleur
     *      La couleur du Joueur.
     * 
     * @see Joueur#nom
     * @see Joueur#couleur
     * 
     * @see Humain
     * @see Ordinateur
     */
    public Joueur(String nom, int couleur){
        this.nom = nom;
        this.couleur = couleur;
    }

    /**
     * Vérifie si le coup du Joueur est possible et place un pion sur 
     * les coordonnées choisi par le Joueur dans le Plateau.
     * 
     * @param p
     *      Le Plateau où va joué le Joueur.
     * 
     * @see Plateau
     */
    public void joue(Plateau p){}

    /**
     * Traduit l'entier en paramètre et la transforme en une chaîne de caractère.
     * @param x
     *      L'entier donné en paramètre.
     * @return
     *      La coordonnée alphabétique de la colonne.
     */
    public String chiffreVersLettre(int x){
        String col = "";
        if(x==1) col = "A";
        else if(x==2) col = "B";
        else if(x==3) col = "C";
        else if(x==4) col = "D";
        else if(x==5) col = "E";
        else if(x==6) col = "F";
        else if(x==7) col = "G";
        else if(x==8) col = "H";
        else if(x==9) col = "I"; 
        else if(x==10) col = "J";
        else if(x==11) col = "K";
        else if(x==12) col = "L";
        else if(x==13) col = "M";
        else if(x==14) col = "N";
        else if(x==15) col = "O";
        else if(x==16) col = "P";
        else if(x==17) col = "Q";
        else if(x==18) col = "R";
        else col = "S";
        return col;
    }
    
    /**
     * Retourne le nom du Joueur.
     * @return Le nom du Joueur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Met à jour le nom du Joueur.
     * @param nom
     *      Le nouveau nom du Joueur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne la couleur du Joueur.
     * @return La couleur du Joueur.
     */
    public int getCouleur() {
        return couleur;
    }

    /**
     * Met à jour la couleur du Joueur.
     * @param couleur
     *      La nouvelle couleur du Joueur.
     */
    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
}
    