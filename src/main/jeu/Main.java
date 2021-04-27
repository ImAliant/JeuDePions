package main.jeu;

import java.util.Scanner;

public class Main {
    protected static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Plusieurs modes de jeux sont disponibles : JcJ, JcO, OcJ, OcO.");
        System.out.println("Sélectionnez un mode de jeu !");
        
        String repMode = scanner.nextLine();
        String nom1 = "";

        switch (repMode) {
            case "JcJ":
                System.out.println("Premier joueur : Quel est votre nom ?");
                nom1 = scanner.nextLine();

                for(int i = 0; i < nom1.length(); i++){
                    System.out.print('-');
                }
                System.out.println();

                System.out.println("Second joueur : Quel est votre nom ?");
                String nom2 = scanner.nextLine();

                for(int i = 0; i < nom1.length(); i++){
                    System.out.print('-');
                }
                System.out.println();

                Jeu j1 =new Jeu(new Humain(nom1, 1), new Humain(nom2, 2));
                j1.joue();
                break;
        
            case "JcO":
                System.out.println("Quel est votre nom ?");
                nom1 = scanner.nextLine();

                for(int i = 0; i < nom1.length(); i++){
                    System.out.print('-');
                }
                System.out.println();

                Jeu j2 =new Jeu(new Humain(nom1, 1), new Ordinateur(2));
                j2.joue();
                break;
            case "OcJ":
                System.out.println("Quel est votre nom ?");
                nom1 = scanner.nextLine();

                for(int i = 0; i < nom1.length(); i++){
                    System.out.print('-');
                }
                System.out.println();

                Jeu j3 =new Jeu(new Ordinateur(1), new Humain(nom1, 2));
                j3.joue();
            case "OcO":
                Jeu j4 =new Jeu(new Ordinateur(1), new Ordinateur(2));
				j4.joue();
				break;
    }
}
