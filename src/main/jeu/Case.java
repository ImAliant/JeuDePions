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
        li =new ArrayList<kuplet>();
        kuplet k =new kuplet(x, y, p);
        li.add(k); 
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

    
}
