package main.jeu;

import java.util.ArrayList;
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
                
                kuplet kuMaxScore = kupletMaxScore(p);

                col = kuMaxScore.getC()[0].getX()+1;

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
                System.out.println("L'ordinateur joue en " + (col+1) +".");
                
                for(int i = 0; i < p.getListKu().size(); i++){
                    for(int loop = 0; loop < p.getK(); loop++){
                        if(p.getListKu().get(i).getC()[loop].getX() == col && p.getListKu().get(i).getC()[loop].getY() == lig){
                            p.getListKu().get(i).score();    
                        }
                    }
                }
            }
        }
        else{
            int col = 0;
            int lig = 0;

            while(!placement){
                
                kuplet maxScore = kupletMaxScore(p);

                col = maxScore.getC()[0].getX()+1;
                lig = maxScore.getC()[0].getY()+1;

                if((col >= 1 && col <= p.getN()) && (lig >=1 && lig <= p.getM())){
                    if(p.getCases()[col][lig].getEtat() == '.'){
                        placement = true;
                    }
                    else{
                        placement = false;
                    }
                }
                else{
                    placement = false;
                }

                p.getCases()[col][lig].setEtat(this.getCouleur());
                System.out.println("L'ordinateur joue en " + (col+1) + ", " + (lig+1) + ".");
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

    public kuplet kupletMaxScore(Plateau p){
        int maxScore = 0;
        Random random =new Random();

        for(int i = 0; i < p.getListKu().size()-1; i++){
            if(p.getListKu().get(i+1).getScore() >= p.getListKu().get(i).getScore())
                maxScore = p.getListKu().get(i+1).getScore();
        }
        ArrayList<kuplet> listKuMAXScore =new ArrayList<kuplet>();
        for(int i = 0; i < p.getListKu().size(); i++){
            if(maxScore == p.getListKu().get(i).getScore())
                listKuMAXScore.add(p.getListKu().get(i));
        }
        int indiceMaxScore = random.nextInt(listKuMAXScore.size());
        kuplet kuMaxScore = listKuMAXScore.get(indiceMaxScore);
        return kuMaxScore;
    }
}
