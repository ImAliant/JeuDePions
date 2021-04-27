package main.jeu;

import java.util.ArrayList;

public class Case {
    private Plateau p;
    private ArrayList<kuplet> li;
    private int etat;
    private int score;
    private int x;
    private int y;

    Case(int etat, int x, int y, Plateau p, ArrayList<kuplet> li){
        this.p = p;
        this.x = x;
        this.y = y;
        this.etat = etat;
        this.li = li;
        this.score = 1;
    }    

    public ArrayList<kuplet> initialisation(Plateau p){
        li =new ArrayList<kuplet>();
        for(int loop = 0; loop < p.getListKu().size(); loop++){
            for(int loop2 = 0; loop2 < p.getK(); loop2++){
                if(p.getListKu().get(loop).getC()[loop2].getX() == this.x && p.getListKu().get(loop).getC()[loop2].getY() == this.y){
                    kuplet k = p.getListKu().get(loop);
                    li.add(k);
                }
            }
        }
        return li;
    }

    public int score(){
        if(this.etat != 0)
            score = 0;
        else{
            int scr = 0;
            for(int i = 0; i < li.size(); i++){
                scr += li.get(i).getScore();
            }
            score = scr;
        }
        return score;
    }

    public int getIntEtat(){
        return etat;
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