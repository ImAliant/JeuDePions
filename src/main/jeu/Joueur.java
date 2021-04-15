package main.jeu;

public class Joueur {
    private String nom;
    private int couleur;

    public Joueur(String nom, int couleur){
        this.nom = nom;
        this.couleur = couleur;
    }

    public void joue(Plateau p){}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getCouleur() {
        return couleur;
    }

    public void setCouleur(int couleur) {
        this.couleur = couleur;
    }
    
}
