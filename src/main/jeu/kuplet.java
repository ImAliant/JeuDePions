package main.jeu;

public class kuplet{
	private Plateau p;
    private int score;
    private Case[] c;

    public kuplet(Plateau p, Case[] c){
        this.p = p;
        this.c = c;
        score=7;
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

    public Case[] getC() {
        return c;
    }

    public void setC(Case[] c) {
        this.c = c;
    }
    
    public int countEtat(char etat) {
    	int cpt=0;
    	for(int i=0;i<c.length;i++) {
    		if(c[i].getEtat()==etat) {
    			cpt++;
    		}
    	}
    	return cpt;
    }
    
    public int score() {
        int x=countEtat('X');
        int y=countEtat('O');
        if(x>=1 && y>=1) {
            score=0;
            return score;
        }
        int i=1;
        if(x>=1 && y==0) {
            while(i!=x+1) {
                i++;
                score+=500;
            }
        }
        else if(x==0 && y>=1) {
            while(i!=y+1) {
                i++;
                score+=1000;
            }
        }
        return score;
    }
}