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
                
                Case caseMaxScore = caseMaxScore(p);

                col = caseMaxScore.getX();

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
            for(int i = 0; i < p.getCases().length; i++){
                for(int j = 0; j < p.getCases()[i].length; j++){
                    p.getCases()[i][j].score();
                }
            }
        }
        else{
            int col = 0;
            int lig = 0;

            while(!placement){
                
                Case caseMaxScore = caseMaxScore(p);

                col = caseMaxScore.getX();
                lig = caseMaxScore.getY();

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
            }

            p.getCases()[col][lig].setEtat(this.getCouleur());
                
            String sCol = chiffreVersLettre(col+1);

            if(p.getScan().equals("Morpion") || p.getScan().equals("ConfigPerso"))
                System.out.println("L'ordinateur joue en " + (col+1) + ", " + (lig+1) + ".");
            else{
                System.out.println("L'ordinateur joue en " + sCol + ", " + (lig+1) + ".");
            }

            for(int i = 0; i < p.getListKu().size(); i++){
                p.getListKu().get(i).score();
            }
            for(int i = 0; i < p.getCases().length; i++){
                for(int j = 0; j < p.getCases()[i].length; j++){
                    p.getCases()[i][j].score();
                }
            }
        }
    }

    public Case caseMaxScore(Plateau p){
        Case caseMaxScore = p.getCases()[0][0];
        for(int i = 0; i < p.getCases().length-1; i++){
            for(int j = 0; j < p.getCases()[i].length; j++){
                if(caseMaxScore.getScore() < p.getCases()[i][j].getScore())
                    caseMaxScore = p.getCases()[i][j];
            }
        }
        ArrayList<Case> casesMaxScore =new ArrayList<Case>();
        for(int i = 0; i < p.getCases().length-1; i++){
            for(int j = 0; j < p.getCases()[i].length; j++){
                if(p.getCases()[i][j] == caseMaxScore){
                    casesMaxScore.add(p.getCases()[i][j]);
                }
            }
        }
        int index = new Random().nextInt(casesMaxScore.size());
        caseMaxScore = casesMaxScore.get(index);
        return caseMaxScore;
    }
}
