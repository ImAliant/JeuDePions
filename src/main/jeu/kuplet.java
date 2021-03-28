package main.jeu;

import java.util.ArrayList;

public class kuplet{
	private Plateau p;
    private int score;
    private ArrayList<Case[]> listKu;
    private Case[] c;

    public kuplet(Plateau p, Case[] c){
        this.p = p;
        this.c = new Case[p.getK()]; 
        /*for(int i=0;i<c.length;i++) {
        	if(c[i].getEtat())
        }*/
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

    public void setListKu(ArrayList<Case[]> listKu) {
        this.listKu = listKu;
    }
}
