package main.jeu;

import java.util.ArrayList;

public class Case {
    private Plateau p;
    private int etat;
    private ArrayList<kuplet> li;
    private int x;
    private int y;

    Case(int etat, int x, int y, Plateau p){
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.p = p;
        p.initialisationKuplet();
        for(int loop = 0; loop < p.getListKu().size(); loop++){
        	for(int i = 0; i < p.getListKu().get(loop).length; i++){    
           			if(p.getListKu().get(loop)[i].getX() == x && p.getListKu().get(loop)[i].getY() == y){           			
        				li.add(new kuplet(p, p.getListKu().get(loop)));
        			}        		
           	}
        }
    }

    
    public char getEtat() {
        if(etat == 1){
            return 'X';
        }
        if(etat == 2){
            return 'O';
        }
        else return '.';
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public ArrayList<kuplet> getLi() {
        return li;
    }

    public void setLi(ArrayList<kuplet> li) {
        this.li = li;
    }

    public Plateau getP() {
        return p;
    }

    public void setP(Plateau p) {
        this.p = p;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    

    
}
