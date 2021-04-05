package Test;

import java.util.Scanner;

public class JeuGomTest {
    JeuGomTest(PlateauTest p){
        /* VARIABLES */
        int gagnant = 0;
        int pColonnes = p.getColonnes();
        int lignes = p.getLignes();
        int alignReq = p.getAlignReq();
        char[][] plateau = p.getPlateau();

        Scanner scanner = new Scanner(System.in);

        for(int i = 1; i < pColonnes*lignes; i++){
            /* AFFICHAGE DU PLATEAU */
            System.out.println("Tour " + i + ", Etat du plateau :");
			
            for (int loop = 0; loop < pColonnes + 2 + 2 * pColonnes; loop++)
				System.out.print('-');
            System.out.println();
            
            for (int y = 0; y < lignes; y++) {
				System.out.print("|");
				for (int x = 0; x < pColonnes; x++) {
					System.out.print(" " + plateau[x][y] + " ");
				}
				System.out.print('|');
				System.out.println();
			}
            for (int loop = 0; loop < pColonnes + 2 + 2 * pColonnes; loop++)
				System.out.print('-');
			System.out.println();

            // Placements du jeton:
			System.out.println("Tour du joueur " + (i % 2 == 1 ? 'X' : 'O'));

            boolean placement = false;
            int col = 0;
            int lig = 0;

            while(!placement){
                System.out.println("Entrez le numéro de la colonne entre 1 et " + pColonnes + " ...");
                String lC = scanner.nextLine();
                try{
                    col = Integer.valueOf(lC);

                    if(col >= 1 && col <= pColonnes){
                        
                        System.out.println("Entrez le numéro de la colonne entre 1 et " + lignes);
                        String lL = scanner.nextLine();
                        lig = Integer.valueOf(lL);

                        if(lig >= 1 && lig <= lignes){
                            if(plateau[col-1][lig-1] != '.'){
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
                } catch(Exception e) {
                    System.out.println("Nombre incorrect, réitérez");
                }
            }
            plateau[col-1][lig-1] = (i%2 == 1 ? 'X' : '0');

            char symbole = (i % 2 == 1 ? 'X' : 'O');

            int max = 0;
            int x;
            int y;
            int somme;

            x = col - 1;
			y = lig - 1;
            somme = -1;
            while (y >= 0 && x >= 0 && plateau[x][y] == symbole) {
				y--;
				x--;
				somme++;
			}
			x = col - 1;
			y = lig - 1;
			while (y < lignes && x < pColonnes && plateau[x][y] == symbole) {
				y++;
				x++;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> diagonale HD-BG
			x = col - 1;
			y = lig - 1;
			somme = -1;
			while (y >= 0 && x < pColonnes && plateau[x][y] == symbole) {
				y--;
				x++;
				somme++;
			}
			x = col - 1;
			y = lig - 1;
			while (y < lignes && x >= 0 && plateau[x][y] == symbole) {
				y++;
				x--;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> verticale:
			x = col - 1;
			y = lig - 1;
			somme = -1;
			while (y >= 0 && plateau[x][y] == symbole) {
				y--;
				somme++;
			}
			y = lig - 1;
			while (y < lignes && plateau[x][y] == symbole) {
				y++;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> horizontale:
			x = col - 1;
			y = lig - 1;
			somme = -1;
			while (x >= 0 && plateau[x][y] == symbole) {
				x--;
				somme++;
			}
			x = col - 1;
			while (x < pColonnes && plateau[x][y] == symbole) {
				x++;
				somme++;
			}
			if (somme > max)
				max = somme;

			if (max >= alignReq) {
				gagnant = (i % 2 == 1 ? 1 : 2);
				i = pColonnes * lignes + 1;
			}
            System.out.println();

            for (int loop = 0; loop < pColonnes + 2 + 2 * pColonnes; loop++)
				System.out.print('*');
            System.out.println();
        }
        System.out.println();
		System.out.println("****FIN DE PARTIE****");
		if (gagnant == 0)
			System.out.println("*******EGALITE*******");
		if (gagnant == 1)
			System.out.println("****VICTOIRE DE X****");
		if (gagnant == 2)
			System.out.println("****VICTOIRE DE O****");
        
        for (int loop = 0; loop < pColonnes + 2 + 2 * pColonnes; loop++)
			System.out.print('-');
		System.out.println();

		for (int y = 0; y < lignes; y++) {
			System.out.print('|');
			for (int x = 0; x < pColonnes; x++) {
				System.out.print(" " + plateau[x][y] + " ");
			}
			System.out.print('|');
			System.out.println();
		}

		for (int loop = 0; loop < pColonnes + 2 + 2 * pColonnes; loop++)
			System.out.print('-');
		System.out.println();
    }
}
