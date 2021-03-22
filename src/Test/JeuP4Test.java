package main.jeu;

import java.util.Scanner;
public class JeuP4Test {
    JeuP4Test(PlateauTest p){
        /* VARIABLES */
        int gagnant = 0;
        int pColonnes = p.getColonnes();
        int lignes = p.getLignes();
        int alignReq = p.getAlignReq();
        char[][] plateau = p.getPlateau();

        Scanner scanner = new Scanner(System.in);

        for(int i = 1 ; i <= pColonnes * lignes; i++) {

			/* AFFICHAGE DU PLATEAU */
			System.out.println("Tour " + i + ", Etat du plateau :");

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

			// Placements du jeton:
			System.out.println("Tour du joueur " + (i % 2 == 1 ? 'X' : 'O'));
			System.out.println("Entrez le numéro de la colonne entre 1 et " + pColonnes + " ...");
			boolean placement = false;
			int colonne = -1;
			while (!placement) {
				colonne = -1;
				String ligne = scanner.nextLine();
				/* Vérification que le jeton est bien placé entre 1 et 7 */
				try {
					colonne = Integer.valueOf(ligne);

					if (colonne >= 1 && colonne <= pColonnes) {
						if (plateau[colonne - 1][0] != '.') {
							System.out.println("Colonne pleine, réitérez");
						} else {
							placement = true;
						}
					} else {
						System.out.println("Nombre incorrect, réitérez");
					}

				} catch (Exception e) {
					System.out.println("Nombre incorrect, réitérez");
				}

			}
			// placement du jeton:
			int rang = lignes - 1;
			while (plateau[colonne - 1][rang] != '.') {
				rang--;
			}
			plateau[colonne - 1][rang] = (i % 2 == 1 ? 'X' : 'O');

			// Détection de victoire:

			// symbole en cours:
			char symbole = (i % 2 == 1 ? 'X' : 'O');
			// nombre alignés maximal:
			int max = 0;
			int x;
			int y;
			int somme;

			// --> diagonale HG-BD
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (y >= 0 && x >= 0 && plateau[x][y] == symbole) {
				y--;
				x--;
				somme++;
			}
			x = colonne - 1;
			y = rang;
			while (y < lignes && x < pColonnes && plateau[x][y] == symbole) {
				y++;
				x++;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> diagonale HD-BG
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (y >= 0 && x < pColonnes && plateau[x][y] == symbole) {
				y--;
				x++;
				somme++;
			}
			x = colonne - 1;
			y = rang;
			while (y < lignes && x >= 0 && plateau[x][y] == symbole) {
				y++;
				x--;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> verticale:
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (y >= 0 && plateau[x][y] == symbole) {
				y--;
				somme++;
			}
			y = rang;
			while (y < lignes && plateau[x][y] == symbole) {
				y++;
				somme++;
			}
			if (somme > max)
				max = somme;

			// --> horizontale:
			x = colonne - 1;
			y = rang;
			somme = -1;
			while (x >= 0 && plateau[x][y] == symbole) {
				x--;
				somme++;
			}
			x = colonne - 1;
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

			System.out.println("********************************");
		}
		System.out.println();
		System.out.println("*********************");
		System.out.println("****FIN DE PARTIE****");
		System.out.println("*********************");
		if (gagnant == 0)
			System.out.println("*******EGALITE*******");
		if (gagnant == 1)
			System.out.println("****VICTOIRE DE X****");
		if (gagnant == 2)
			System.out.println("****VICTOIRE DE O****");
		System.out.println("*********************");

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
