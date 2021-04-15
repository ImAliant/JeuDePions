package main.jeu;

public class Ordinateur extends Joueur{
    public Ordinateur(int couleur){
        super("L'ordinateur", couleur);
    }
    
    public void joue(Plateau p){
        /*boolean placement = false;

        kuplet maxScore = p.getListKu().get(0);
        for(int i = 1; i < p.getListKu().size(); i++){
            if(p.getListKu().get(i).getScore() > maxScore.getScore())
                maxScore = p.getListKu().get(i);
        }

        if(p.getScan().equals("Puissance4")){
            int col = -1;
            while(!placement){   
                try{
                    col = maxScore.caseVide(maxScore.getC()).getX();
                    if(col >= 0 && col <= p.getN()){
                        if(p.getCases()[col][0].getEtat() != '.'){
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
            while(p.getCases()[col][lig].getEtat() != '.'){
                lig--;
            }
            p.getCases()[col][lig].setEtat(this.getCouleur());
            
            for(int i = 0; i < p.getListKu().size(); i++){
                for(int loop = 0; loop < p.getK(); loop++){
                    if(p.getListKu().get(i).getC()[loop].getX() == col && p.getListKu().get(i).getC()[loop].getY() == lig){
                        p.getListKu().get(i).score();
                    }
                }
            }
        }
        else{
            int col = 0;
            int lig = 0;

            while(!placement){
                try{
                    col = maxScore.caseVide(maxScore.getC()).getX();
                    if(col >= 0 && col <= p.getN()){
                        lig = maxScore.caseVide(maxScore.getC()).getY();
                        if(lig >= 0 && lig <= p.getM()){
                            if(p.getCases()[col][lig].getEtat() != '.'){
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
                }
                catch(Exception e){
                    System.out.println("-> COUP NON VALIDE ( Votre nombre n'est pas correct )");
                }
            }
            p.getCases()[col][lig].setEtat(this.getCouleur());
            
            for(int i = 0; i < p.getListKu().size(); i++){
                for(int loop = 0; loop < p.getK(); loop++){
                    if(p.getListKu().get(i).getC()[loop].getX() == col && p.getListKu().get(i).getC()[loop].getY() == lig){
                        p.getListKu().get(i).score();
                    }
                }
            }
        }*/
    }
}
