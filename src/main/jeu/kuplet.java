package main.jeu;

public class kuplet{
	private Plateau p;
    private int score;
    private Case[] c;

    public kuplet(Plateau p, Case[] c){
        this.p = p;
        this.c = c;
        switch(c.length) {
        case 5:
        	if(countEtat('X')==c.length-1 && alignement('X', 4) ||countEtat('O')==c.length-1 && alignement('O', 4)) {
            	score=4;
            }
            else if(countEtat('X')==c.length-2 && alignement('X', 3)||countEtat('O')==c.length-2 && alignement('O', 3)) {
            	score=3;
            }
            else if(countEtat('X')==c.length-3 && alignement('X', 2) ||countEtat('O')==c.length-3 && alignement('O', 2)) {
            	score=2;
            }
            else if(countEtat('X')==c.length-4 ||countEtat('O')==c.length-4) {
            	score=1;
            }
            else if(countEtat('X')>=1 && countEtat('O')>=1){
            	score=0;
            }
        	break;
        case 4:
        	if(countEtat('X')==c.length-1 && alignement('X', 3)||countEtat('O')==c.length-1&& alignement('O', 3)) {
            	score=3;
            }
            else if(countEtat('X')==c.length-2 && alignement('X', 2)||countEtat('O')==c.length-2 && alignement('O', 2)) {
            	score=2;
            }
            else if(countEtat('X')==c.length-3 ||countEtat('O')==c.length-3) {
            	score=1;
            }
            else if(countEtat('X')>=1 && countEtat('O')>=1){
            	score=0;
            }
        	break;
        case 3:
        	if(countEtat('X')==c.length-1 && alignement('X', 2)||countEtat('O')==c.length-1 && alignement('O', 2)) {
            	score=2;
            }
            else if(countEtat('X')==c.length-2 ||countEtat('O')==c.length-2) {
            	score=1;
            }
            else if(countEtat('X')>=1 && countEtat('O')>=1){
            	score=0;
            }
        	break;
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
    
    public boolean alignement(char etat, int nbr) {
    	int x=0;
    	for(int i=0;i<c.length;i++) {
    		if(c[i].getEtat()==etat) {
    			x=i;
    			for(int j=i+1;j<nbr;j++) {
    				if(c[j].getEtat()!=etat) {
    					return false;
    				}
    			}
    		}
    	}
    	if(x>0 && c[x].getEtat()=='.' || nbr<c.length && c[nbr].getEtat()=='.') {
    		return true;
    	}
    	return false;
    }
}