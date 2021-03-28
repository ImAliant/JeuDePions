package main.jeu;

import java.util.ArrayList;

public class Case {
    private Plateau p;
    private ArrayList<kuplet> li;
    private int etat;
    private int score;
    private int x;
    private int y;

    Case(int etat, int x, int y, Plateau p){
        this.x = x;
        this.y = y;
        this.etat = etat;
    }
    Case(int etat, int x, int y, Plateau p, ArrayList<kuplet> li){
        this(etat, x, y, p);
        this.li = li;
    }    

    public ArrayList<kuplet> initialisation(Plateau p){
        li =new ArrayList<kuplet>();
        for(int loop = 0; loop < p.getListKu().size(); loop++){
                if(p.getListKu().get(loop).getC()[loop].getX() == this.x && p.getListKu().get(loop).getC()[loop].getY() == this.y){
                    kuplet k = p.getListKu().get(loop);
                    li.add(k);
                }
        }
        return li;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    

    
}
