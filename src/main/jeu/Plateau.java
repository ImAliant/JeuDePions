package main.jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {
    private int K; //Alignement requis ( 4 pour Puissance4 | 5 pour Gomoku )
    private int N; //Colonnes du plateau ( 6 pour Puissance4 | 19 pour Gomoku )
    private int M; //Lignes du plateau ( 7 pour Puissance4 | 19 pour Gomuku )
    private Case[][] cases;
    private ArrayList<kuplet> listKu;

    Plateau(){
        Scanner scanner =new Scanner(System.in);

        // Initialisation du plateau
        System.out.println("Selection de jeu : Gomoku / Puissance4 / Morpion");
        if(scanner.nextLine().equals("Gomoku")){
            K = 5;
            N = 19;
            M = 19;
        }
        else if(scanner.nextLine().equals("Puissance4")){
            K = 4;
            N = 6;
            M = 7;
        }
        else if(scanner.nextLine().equals("Morpion")){
            K = 3;
            N = 3;
            M = 3;
        }
        else{
            System.out.println("Ce jeu n'existe pas !");
        }
        cases =new Case[N][M];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                cases[i][j] =new Case(0, i, j, this, null);
            } 
        }
        

        //LISTE DES KUPLETS DU PLATEAU
        listKu =new ArrayList<kuplet>();
        Case[] c =new Case[K];
        kuplet k;
        int loop = 0; 
        //Kuplets horizontaux
        for(int j = 0; j < M; j++){
            for(int i = 0; i < N-K; i++){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                }
                loop = 0;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
        //Kuplets verticaux
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M-K; j++){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                }
                loop = 0;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
        //Kuplets HG-BD
        for(int i = 0; i < N-K; i++){
            for(int j = 0; j < M-K; j++){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                    i++;
                    j++;
                }
                loop = 0;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }
        //Kuplets BG-HD
        for(int i = 0; i < N-K; i++){
            for(int j = M-1; j >= 4; j--){
                c =new Case[K];
                while(loop < K){
                    c[loop] = cases[i][j];
                    loop++;
                    i++;
                    j--;
                }
                loop = 0;
                k =new kuplet(this, c);
                listKu.add(k);
            }
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                cases[i][j].setLi(cases[i][j].initialisation(this));
            }
        }
    }
    
    void afficheKuplets(ArrayList<kuplet> listKu){
        for(int i = 0; i < listKu.size(); i++){
            System.out.print("[");
            for(int loop = 0; loop < getK(); loop++){
                System.out.print(listKu.get(i).getC()[loop].getX() + "," + listKu.get(i).getC()[loop].getY() + " ");
            }
            System.out.print("]");
        } 
    }

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

    public Case[][] getCases() {
        return cases;
    }

    public void setCases(Case[][] cases) {
        this.cases = cases;
    }

    public ArrayList<kuplet> getListKu() {
        return listKu;
    }

    public void setListKu(ArrayList<kuplet> listKu) {
        this.listKu = listKu;
    }

    
}



