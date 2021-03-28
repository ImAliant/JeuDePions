package main.jeu;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau {
    private int K; //Alignement requis ( 4 pour Puissance4 | 5 pour Gomoku )
    private int N; //Colonnes du plateau ( 6 pour Puissance4 | 19 pour Gomoku )
    private int M; //Lignes du plateau ( 7 pour Puissance4 | 19 pour Gomuku )
    private Case[][] cases;
    private ArrayList<Case[]> listKu;
    private Case[] c;

    Plateau(){
        Scanner scanner =new Scanner(System.in);

        // Initialisation du plateau
        System.out.println("Selection de jeu : Gomoku / Puissance4 / Morpion");
        if(scanner.nextLine().equals("Gomoku")){
            K = 5;
            N = 19;
            M = 19;
            cases =new Case[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    cases[i][j] =new Case(0, i, j, this);
                } 
            }
        }
        else if(scanner.nextLine().equals("Puissance4")){
            K = 4;
            N = 6;
            M = 7;
            cases =new Case[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    cases[i][j] =new Case(0, i, j, this);
                } 
            }
        }
        else if(scanner.nextLine().equals("Morpion")){
            K = 3;
            N = 3;
            M = 3;
            cases =new Case[N][M];
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    cases[i][j] =new Case(0, i, j, this);
                } 
            }
        }
        else{
            System.out.println("Ce jeu n'existe pas !");
        }
    }
    
    public void initialisationKuplet(){
        listKu =new ArrayList<Case[]>();
        //Kuplets horizontaux
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int loop = 0; loop < K; loop++){
                    c[loop] = cases[i][j];
                    i++;
                }
            }
            listKu.add(c);
        }
        //Kuplets verticaux
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int loop = 0; loop < K; loop++){
                    c[loop] = cases[i][j];
                    j++;
                }
            }
            listKu.add(c);
        }
        //Kuplets HG-BD
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int loop = 0; loop < K; loop++){
                    c[loop] = cases[i][j];
                    i++;
                    j++;
                }
            }
            listKu.add(c);
        }
        //Kuplets BG-HD
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                for(int loop = 0; loop < K; loop++){
                    c[loop] = cases[i][j];
                    i++;
                    j--;
                }
            }
            listKu.add(c);
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

    public ArrayList<Case[]> getListKu() {
        return listKu;
    }
}
