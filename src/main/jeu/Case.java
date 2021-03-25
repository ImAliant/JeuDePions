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

        kuplet k =new kuplet(p);
        li =new ArrayList<kuplet>();
        for(int loop = 0; loop < k.getListKu().size(); loop++){
                if(k.getListKu().get(loop)[loop].getX() == x){
                    //li.add();
                }
                if(k.getListKu().get(loop)[loop].getY() == y){
                    //li.add();
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
