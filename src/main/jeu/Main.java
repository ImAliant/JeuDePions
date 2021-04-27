package main.jeu;

import java.util.Scanner;

public class Main {
    protected static Scanner scanner =new Scanner(System.in);
    public static void main(String[] args){
        System.out.println("Premier joueur : Quel est votre nom ?");
        String nom1 = scanner.nextLine();

        for(int i = 0; i < nom1.length(); i++){
            System.out.print('-');
        }
        System.out.println();

        Jeu j =new Jeu(new Humain(nom1, 1), new Ordinateur(2));
        j.joue();
    }
}
