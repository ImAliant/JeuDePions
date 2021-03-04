package main.jeu;

public class Plateau {
    
    private int alignReq; //Alignement requis ( 4 pour Puissance4 | 5 pour Gomoku )
    private int colonnes; //Colonnes du plateau ( 6 pour Puissance4 | 19 pour Gomoku )
    private int lignes; //Lignes du plateau ( 7 pour Puissance4 | 19 pour Gomuku )
    private char[][] plateau;

    Plateau(int alignReq, int colonnes, int lignes){
        this.alignReq = alignReq;
        this.colonnes = colonnes;
        this.lignes = lignes;
        
        plateau =new char[colonnes][lignes];
        for(int i = 0 ; i < colonnes ; i++)
			for(int j = 0 ; j < lignes ; j++)
				plateau[i][j] = '.';
    }

    public int getAlignReq() {
        return alignReq;
    }

    public void setAlignReq(int alignReq) {
        this.alignReq = alignReq;
    }

    public int getColonnes() {
        return colonnes;
    }

    public void setColonnes(int colonnes) {
        this.colonnes = colonnes;
    }

    public int getLignes() {
        return lignes;
    }

    public void setLignes(int lignes) {
        this.lignes = lignes;
    }

    public char[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(char[][] plateau) {
        this.plateau = plateau;
    }
    
}
