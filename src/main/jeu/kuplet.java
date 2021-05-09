package main.jeu;

public class kuplet{
	private Plateau p;
    private int score;
    private Case[] c;

    public kuplet(Plateau p, Case[] c){
        this.p = p;
        this.c = c;
        this.score = 7;
    }

    public int countEtat(char etat) {
    	int cpt=0;
    	for(int i=0;i<getC().length; i++) {
    		if(c[i].getEtat()==etat) {
    			cpt++;
    		}
    	}
    	return cpt;
    }

    //Getters Setters
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

    public Case[] getC() {
        return c;
    }

    public void setC(Case[] c) {
        this.c = c;
    }
}