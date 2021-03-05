package main.jeu;

public class Plateau {
    private int K; //Alignement requis ( 4 pour Puissance4 | 5 pour Gomoku )
    private int N; //Colonnes du plateau ( 6 pour Puissance4 | 19 pour Gomoku )
    private int M; //Lignes du plateau ( 7 pour Puissance4 | 19 pour Gomuku )

    Plateau(int K, int N, int M){
        this.K = K;
        this.N = N;
        this.M = M;
    }
    Plateau(){}

    public int getK() {
        return K;
    }

    public void setK(int k) {
        K = k;
    }

    public int getN() {
        return N;
    }

    public void setN(int n) {
        N = n;
    }

    public int getM() {
        return M;
    }

    public void setM(int m) {
        M = m;
    }

    
}
