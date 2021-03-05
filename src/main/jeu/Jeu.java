package main.jeu;

import java.util.Scanner;

public class Jeu {
    private Case[][] cases;
    private k_uplet ku;

    Jeu(Plateau p){
        Scanner scanner =new Scanner(System.in);

        // Initialisation du plateau
        System.out.println("Selection de jeu : Gomoku / Puissance4 / Morpion");
        if(scanner.nextLine().equals("Gomoku")){
            p =new Plateau(5,19,19);
            cases =new Case[p.getN()][p.getM()];
            for(int i = 0; i < p.getN(); i++){
                for(int j = 0; j < p.getM(); j++){
                    cases[i][j] =new Case('.');
                } 
            }
        }
        else if(scanner.nextLine().equals("Puissance4")){
            p =new Plateau(4,6,7);
            cases =new Case[p.getN()][p.getM()];
            for(int i = 0; i < p.getN(); i++){
                for(int j = 0; j < p.getM(); j++){
                    cases[i][j] =new Case('.');
                } 
            }
        }
        else if(scanner.nextLine().equals("Morpion")){
            p =new Plateau(3, 3, 3);
            cases =new Case[p.getN()][p.getM()];
            for(int i = 0; i < p.getN(); i++){
                for(int j = 0; j < p.getM(); j++){
                    cases[i][j] =new Case('.');
                } 
            }
        }
        else{
            System.out.println("Ce jeu n'existe pas !");
        }
        
        // Affichage du plateau
        for(int i = 1; i<p.getN()*p.getM(); i++){
            System.out.println("Tour " + i + ", Etat du plateau :");

            System.out.print("  ");
            for(int ch = 1; ch <= p.getN(); ch++)
                System.out.print(ch + " ");
            for(int loop = 0; loop < p.getN() + 2 + 2 * p.getN(); loop++)
                System.out.print('-');
            System.out.println();
        }
    }

    public Case[][] getCases() {
        return cases;
    }

    public void setCases(Case[][] cases) {
        this.cases = cases;
    }

    public k_uplet getKu() {
        return ku;
    }

    public void setKu(k_uplet ku) {
        this.ku = ku;
    }
}
