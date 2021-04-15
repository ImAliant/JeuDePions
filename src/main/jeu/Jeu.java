package main.jeu;

import java.util.Scanner;

public class Jeu {
    private Plateau p;

    Jeu(){
        int gagnant = 0;
        int i = 1;
        p = new Plateau();
        while(gagnant == 0){
            affichagePlateau(i, p);
            placementJeton(gagnant, i , p);
            i++;
        }
    }
    
    void affichagePlateau(int tour, Plateau p){
        System.out.println("Tour " + tour + ", Etat du plateau :");
        System.out.println();
        if(p.getScan().equals("Gomoku")){
            System.out.print("    ");
            char ascii = 65;
            int a = 65;
            for(int c = 65; c < a + p.getN(); c++){
                ascii = (char) c;
                String lettre = Character.toString(ascii);
                System.out.print(lettre + "  ");
            }
        }
        else if(p.getScan().equals("Morpion")){
            System.out.print("    ");
            for(int i = 1; i <= p.getN(); i++)
                System.out.print(i + "  ");
        }
        else{
            System.out.print("  ");
            for(int i = 1; i <= p.getN(); i++)
                System.out.print(i + "  ");
        }
        System.out.println();
        if(p.getScan().equals("Gomoku") || p.getScan().equals("Morpion"))
            System.out.print("  ");
        for (int loop = 0; loop < p.getN() + 2 + 2 * p.getN(); loop++)
			System.out.print('-');
        System.out.println();
        
        int compt = 1;
        if(p.getScan().equals("Gomoku")){
            for (int y = 0; y < p.getM(); y++) {
                System.out.print(compt);
                compt++;
                if(compt <= 10){
			        System.out.print(" |");
			        for (int x = 0; x < p.getN(); x++) {
			        	System.out.print(" " + p.getCases()[x][y].getEtat() + " ");
			        }
			        System.out.print('|');
                }
                else{
                    System.out.print('|');
			        for (int x = 0; x < p.getN(); x++) {
			        	System.out.print(" " + p.getCases()[x][y].getEtat() + " ");
			        }
			        System.out.print('|');
                }
                System.out.println();
		    }
        }
        else if(p.getScan().equals("Puissance4")){
            for (int y = 0; y < p.getM(); y++) {
                System.out.print('|');
                for (int x = 0; x < p.getN(); x++) {
                    System.out.print(" " + p.getCases()[x][y].getEtat() + " ");
                }
                System.out.print('|');
                System.out.println();
            }
        }
        else{
            for (int y = 0; y < p.getM(); y++) {
                System.out.print(compt);
                compt++;
                System.out.print(" |");
                for (int x = 0; x < p.getN(); x++) {
                    System.out.print(" " + p.getCases()[x][y].getEtat() + " ");
                }
                System.out.print('|');
                System.out.println();
            }
        }
        if(p.getScan().equals("Gomoku") || p.getScan().equals("Morpion"))
            System.out.print("  ");
        for (int loop = 0; loop < p.getN() + 2 + 2 * p.getN(); loop++)
			System.out.print('-');
        System.out.println();
        System.out.println();
    }
    
    void placementJeton(int gagnant, int tour, Plateau p){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Tour du joueur " + (tour % 2 == 1 ? 'X' : '0'));

        boolean placement = false;

        if(p.getScan().equals("Puissance4")){

            int col = -1;

            while(!placement){
                System.out.println("Entrez le numéro de la colonne entre 1 et " + p.getN() + " ...");
                String lC =scanner.nextLine();
                try{
                    col = Integer.valueOf(lC);
                    if(col >= 1 && col <= p.getN()){
                        if(p.getCases()[col-1][0].getEtat() != '.'){
                            System.out.println("Cette colonne est pleine.");
                        } 
                        else {
                            placement = true;
                        }
                    } 
                    else {
				    	System.out.println("Nombre incorrect, réitérez");
				    }
                }
                catch(Exception e){
                    System.out.println("Nombre incorrect, réitérez");
                }
            }

            int lig = p.getM()-1;
		    while(p.getCases()[col - 1][lig].getEtat() != '.'){
			    lig--;
		    }
		    p.getCases()[col - 1][lig].setEtat((tour % 2 == 1 ? 1 : 2));
            victoire(gagnant, col, lig, tour);
        }
        else{
            int col = 0;
            int lig = 0;
        
            while(!placement){
                System.out.println("Entrez le numéro de la colonne entre 1 et " + p.getN() + " ...");
                String lC =scanner.nextLine();
                try{
                    col = lettreVersChiffre(lC);

                    if(col >= 1 && col <= p.getN()){
                        System.out.println("Entrez le numéro de la ligne entre 1 et " + p.getM() + " ...");
                        String lL =scanner.nextLine();
                        lig = Integer.valueOf(lL);
                        if(lig >= 1 && lig <= p.getM()){
                            if(p.getCases()[col-1][lig-1].getEtat() != '.'){
                                System.out.println("Il y a une piece à cette emplacement.");
                            } else {
                                placement = true;
                            }
                        } else {
                            System.out.println("Nombre incorrect, réitérez");
                        }
                    } else {
                        System.out.println("Nombre incorrect, réitérez");
                    }
                } catch(Exception e){
                    System.out.println("Nombre incorrect, réitérez");
                }
            }
            p.getCases()[col-1][lig-1].setEtat(tour%2 == 1 ? 1 : 2);
            victoire(gagnant, col, lig, tour);
        }
    }
    
    void victoire(int gagnant, int col, int lig, int tour){
        // symbole en cours:
        char symbole = (tour%2 == 1 ? 'X' : 'O');
        // nombre alignés maximal:
        int max = 0;
        int x, y, somme;

        // --> diagonale HG-BD
        x = col-1;
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
            y = lig-1;
        somme = -1;
        while (y >= 0 && x >= 0 && p.getCases()[x][y].getEtat() == symbole) {
            y--;
            x--;
            somme++;
        }
        x = col - 1;
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
            y = lig - 1;
        while (y < p.getM() && x < p.getN() && p.getCases()[x][y].getEtat() == symbole) {
            y++;
            x++;
            somme++;
        }
        if (somme > max)
            max = somme;

        // --> diagonale HD-BG
		x = col - 1;
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
            y = lig - 1;
		somme = -1;
		while (y >= 0 && x < p.getN() && p.getCases()[x][y].getEtat() == symbole) {
			y--;
			x++;
			somme++;
		}
		x = col - 1;
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
		    y = lig - 1;
		while (y < p.getM() && x >= 0 && p.getCases()[x][y].getEtat() == symbole) {
			y++;
			x--;
			somme++;
		}
		if (somme > max)
			max = somme;

		// --> verticale:
		x = col - 1;
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
            y = lig - 1;
		somme = -1;
		while (y >= 0 && p.getCases()[x][y].getEtat() == symbole) {
			y--;
			somme++;
		}
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
		    y = lig - 1;
		while (y < p.getM() && p.getCases()[x][y].getEtat() == symbole) {
			y++;
			somme++;
		}
		if (somme > max)
			max = somme;

		// --> horizontale:
		x = col - 1;
        if(p.getScan().equals("Puissance4"))
            y = lig;
        else
		    y = lig - 1;
		somme = -1;
		while (x >= 0 && p.getCases()[x][y].getEtat() == symbole) {
			x--;
			somme++;
		}
		x = col - 1;
		while (x < p.getN() && p.getCases()[x][y].getEtat() == symbole) {
			x++;
			somme++;
		}
		if (somme > max)
			max = somme;
        if(max >= p.getK()){
            gagnant = (tour%2 == 1 ? 1 : 2);
            tour = p.getN()*p.getM()+1;
        }
        System.out.println();

        System.out.println();

		if (gagnant == 1){
            System.out.println("****FIN DE PARTIE****");
			System.out.println("****VICTOIRE DE X****");
        }
		if (gagnant == 2){
            System.out.println("****FIN DE PARTIE****");
			System.out.println("****VICTOIRE DE O****");
        }
    }
    public int lettreVersChiffre(String s){
        int col = 0;
        if(s.equals("A")||s.equals("a")){
            col = 1;            
        } 
        else if(s.equals("B")||s.equals("b")){
            col = 2;         
        } 
        else if(s.equals("C")||s.equals("c")){
            col = 3;           
        } 
        else if(s.equals("D")||s.equals("d")){
            col = 4;           
        } 
        else if(s.equals("E")||s.equals("e")){
            col = 5;           
        } 
        else if(s.equals("F")||s.equals("f")){
            col = 6;           
        } 
        else if(s.equals("G")||s.equals("g")){
            col = 7;           
        } 
        else if(s.equals("H")||s.equals("h")){
            col = 8;           
        } 
        else if(s.equals("I")||s.equals("i")){
            col = 9;            
        } 
        else if(s.equals("J")||s.equals("j")){
            col = 10;           
        } 
        else if(s.equals("K")||s.equals("k")){
            col = 11;            
        } 
        else if(s.equals("L")||s.equals("l")){
            col = 12;            
        } 
        else if(s.equals("M")||s.equals("m")){
            col = 13;           
        } 
        else if(s.equals("N")||s.equals("n")){
            col = 14;           
        } 
        else if(s.equals("O")||s.equals("o")){
            col = 15;            
        } 
        else if(s.equals("P")||s.equals("p")){
            col = 16;            
        } 
        else if(s.equals("Q")||s.equals("q")){
            col = 17;            
        } 
        else if(s.equals("R")||s.equals("r")){
            col = 18;           
        } 
        else if(s.equals("S")||s.equals("s")){
            col = 19;            
        } 
        return col;
    }
}
