package main.jeu;

import java.util.Random;

public class Ordinateur extends Joueur{
    public Ordinateur(int couleur){
        super("L'ordinateur", couleur);
    }
    
    public void joue(Plateau p){
        boolean placement = false;

        if(p.getScan().equals("Puissance4")){
            int col = 0;

            while(!placement){
                kuplet maxScore = p.getListKu().get(0);
                int score = maxScore.getScore();

                Random random =new Random();

                for(int i = 1; i < p.getListKu().size(); i++){
                    if(p.getListKu().get(i).getScore() > score){
                        maxScore = p.getListKu().get(i);
                        score = maxScore.score();
                    } 
                    else if(p.getListKu().get(i).getScore() == score){
                        int rand = random.nextInt(2-1+1)+1;
                        if(rand == 2){
                            maxScore = p.getListKu().get(i);
                            score = maxScore.score();
                        }
                    }
                }
                
                col = maxScore.getC()[0].getX()+1;

                if(col >= 1 && col <= p.getN()){
                    if(p.getCases()[col][0].getEtat() == '.'){
                        placement = true;
                    }
                    else{
                        placement = false;
                    }
                }
                else{
                    placement = false;
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
        }
    }
}
