package main.jeu;

public class Joueur {
    private String nom;
    private int couleur;

    public Joueur(String nom, int couleur){
        this.nom = nom;
        this.couleur = couleur;
    }

    public void joue(Plateau p){}

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
