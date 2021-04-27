package Test;

public class PlateauTest {
    
    private int K; //Alignement requis ( 4 pour Puissance4 | 5 pour Gomoku )
    private int N; //Colonnes du plateau ( 6 pour Puissance4 | 19 pour Gomoku )
    private int M; //Lignes du plateau ( 7 pour Puissance4 | 19 pour Gomuku )
    private char[][] plateau;

    PlateauTest(int alignReq, int colonnes, int lignes){
        this.K = alignReq;
        this.N = colonnes;
        this.M = lignes;

        plateau = new char[colonnes][lignes];
        for (int i = 0; i < colonnes; i++)
            for (int j = 0; j < lignes; j++)
                plateau[i][j] = '.';
    }

    public int getAlignReq() {
        return K;
    }

    public void setAlignReq(int alignReq) {
        this.K = alignReq;
    }

    public int getColonnes() {
        return N;
    }

    public void setColonnes(int colonnes) {
        this.N = colonnes;
    }

    public int getLignes() {
        return M;
    }

    public void setLignes(int lignes) {
        this.M = lignes;
    }

    public char[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(char[][] plateau) {
        this.plateau = plateau;
    }
    
}
