package main.jeu;

/**
 * <b>Humain est la classe représentant le Joueur de type Humain.</b>
 * <p>
 * Un humain est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un nom.</li>
 * <li> Une couleur, correspondant à la couleur du pion.</li>
 * </ul>
 * La classe Humain est étendue de la classe Joueur.
 * 
 * @see Joueur
 * 
 * @author Alexandre, Aymen, Mouadh, Riad
 */
public class Humain extends Joueur{
    
    /**
     * Constructeur Humain.
     * <p>
     * A la construction d'un objet Humain, le nom correspond à la réponse
     * du Joueur et sa couleur est 1 si il joue en premier ou 2 si il joue
     * en deuxième.
     * @param nom
     *      Le nom du Joueur.
     * @param couleur
     *      La couleur du pion du Joueur.
     * 
     * @see Joueur
     */
    public Humain(String nom, int couleur){
        super(nom, couleur);
    }

    /**
     * Vérifie si le coup de l'humain est possible et place un pion sur 
     * les coordonnées choisi sur le Plateau.
     * 
     * @param p
     *      Le Plateau où le pion doit être placé.
     * 
     * @see Joueur
     * @see Plateau
     */
    public void joue(Plateau p){
        boolean placement = false;

        if(p.getScan().equals("Puissance4")){
            int col = -1;

            while(!placement){
                System.out.println(this.getNom() + " entrez le numero de la colonne ( entre 1 et " + p.getN() + " ): ");
                String lC = Main.scanner.nextLine();
                try{
                    col = Integer.valueOf(lC);
                    if(col >= 1 && col <= p.getN()){
                        if(p.getCases()[col-1][0].getEtat() != '.'){
                            System.out.println("-> COUP NON VALIDE ( Colonne pleine )");
                        }
                        else{
                            placement = true;
                        }
                    }
                    else{
                        System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                    }
                }
                catch(Exception e){
                    System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                }
            }

            int lig = p.getM()-1;
            while(p.getCases()[col-1][lig].getEtat() != '.'){
                lig--;
            }
            p.getCases()[col-1][lig].setEtat(this.getCouleur());
        }
        else if(p.getScan().equals("Morpion") || p.getScan().equals("ConfigPerso")){
            int col = 0;
            int lig = 0;
        
            while(!placement){
                System.out.println(this.getNom() + " entrez le numero de la colonne ( entre 1 et " + p.getN() + " )");
                String lC = Main.scanner.nextLine();
                try{
                    col = Integer.valueOf(lC);

                    if(col >= 1 && col <= p.getN()){
                        System.out.println(this.getNom() + " entrez le numero de la ligne ( entre 1 et " + p.getM() + " )");
                        String lL = Main.scanner.nextLine();
                        lig = Integer.valueOf(lL);
                        if(lig >= 1 && lig <= p.getM()){
                            if(p.getCases()[col-1][lig-1].getEtat() != '.'){
                                System.out.println("-> COUP NON VALIDE ( Piece a cet emplacemnet )");
                            } else {
                                placement = true;
                            }
                        } else {
                            System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                        }
                    } else {
                        System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                    }
                } catch(Exception e){
                    System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                }
            }
            p.getCases()[col-1][lig-1].setEtat(this.getCouleur());
        }
        else{
            int col = 0;
            int lig = 0;
        
            while(!placement){
                System.out.println(this.getNom() + " entrez la lettre de la colonne ( entre A et S )");
                String lC = Main.scanner.nextLine();
                try{
                    col = lettreVersChiffre(lC);
                    if(col >= 1 && col <= p.getN()){
                        System.out.println(this.getNom() + " entrez le numero de la ligne ( entre 1 et " + p.getM() + " )");
                        String lL = Main.scanner.nextLine();
                        lig = Integer.valueOf(lL);
                        if(lig >= 1 && lig <= p.getM()){
                            if(p.getCases()[col-1][lig-1].getEtat() != '.'){
                                System.out.println("-> COUP NON VALIDE ( Piece a cet emplacemnet )");
                            } else {
                                placement = true;
                            }
                        } else {
                            System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                        }
                    } else {
                        System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                    }
                } catch(Exception e){
                    System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                }
            }
            p.getCases()[col-1][lig-1].setEtat(this.getCouleur());
        }
    }

    /**
     * Traduit la lettre donné par le Joueur et la transforme en un entier
     * qui est la coordonnée de la colonne. 
     * @param s
     *      La lettre donnée par le Joueur.
     * @return
     *      La coordonnée de la colonne.
     */
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