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

    public int score() {
    	int x=countEtat('X');
    	int y=countEtat('O');
    	if(x>=1 && y>=1) {
    		score=0;
            return score;
        }
    	switch(x) {
			case 0:
    			if(y==1) {
    				score=35;
					break;
    			}
    			else if(y==2) {
    				score=800;
					break;
    			}
    			else if(y==3) {
    				score=15000;
					break;
    			}
    			else if(y==4) {
    				score=800000;
					break;
    			}
    		case 1:
    			score=15;
				break;
    		case 2:
    			score=400;
				break;
    		case 3:
    			score=1800;
				break;
    		case 4:
    			score=100000;
				break;
    		}
    	return score;
    }

	public int score2() {
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
                score+=580;
            }
        }
        else if(x==0 && y>=1) {
            while(i!=y+1) {
                i++;
                score+=1035;
            }
        }
        return score;
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