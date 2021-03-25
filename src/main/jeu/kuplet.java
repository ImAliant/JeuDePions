package main.jeu;

import java.util.ArrayList;

public class kuplet{
	private Plateau p;
    private int score;
    private ArrayList<Case[]> listKu;
    private Case[] c;

    public kuplet(Plateau p){
        this.p = p;
        c =new Case[p.getK()];
        
    }

    public void initialisationKuplet(Plateau p){
        listKu =new ArrayList<Case[]>();
        //Kuplets horizontaux
        for(int i = 0; i < p.getN(); i++){
            for(int j = 0; j < p.getM(); j++){
                for(int loop = 0; loop < p.getK(); loop++){
                    c[loop] = p.getCases()[i][j];
                    i++;
                }
            }
            listKu.add(c);
        }
        //Kuplets verticaux
        for(int i = 0; i < p.getN(); i++){
            for(int j = 0; j < p.getM(); j++){
                for(int loop = 0; loop < p.getK(); loop++){
                    c[loop] = p.getCases()[i][j];
                    j++;
                }
            }
            listKu.add(c);
        }
        //Kuplets HG-BD
        for(int i = 0; i < p.getN(); i++){
            for(int j = 0; j < p.getM(); j++){
                for(int loop = 0; loop < p.getK(); loop++){
                    c[loop] = p.getCases()[i][j];
                    i++;
                    j++;
                }
            }
            listKu.add(c);
        }
        //Kuplets BG-HD
        for(int i = 0; i > 0; i++){
            for(int j = p.getM(); j >= 0; j--){
                for(int loop = 0; loop < p.getK(); loop++){
                    c[loop] = p.getCases()[i][j];
                    i++;
                    j--;
                }
            }
            listKu.add(c);
        }
    }

    public Plateau getP() {
        return p;
    }

    public void setP(Plateau p) {
        this.p = p;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<Case[]> getListKu() {
        return listKu;
    }

    public void setListKu(ArrayList<Case[]> listKu) {
        this.listKu = listKu;
    }
}