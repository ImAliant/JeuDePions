package main.jeu;

public class kuplet{
	private Plateau p;
    private int score;
    private Case[] c;

    public kuplet(Plateau p, Case[] c){
        this.p = p;
        this.c = c;
        this.score = 1;
    }

    /*public int score(){
        int etat = 0;
        int compteur = 0;
        
        boolean alignement = true;
        for(int i = 0; i < Jeu.joueurs.length; i++){
            if(Jeu.joueurs[i] instanceof Ordinateur)
                etat = Jeu.joueurs[i].getCouleur();
        }
        //CASE VIDE
        while(alignement){
            for(int loop = 0; loop < c.length; loop++){
                if(c[loop].getIntEtat() == 0){
                    compteur++;
                }
                else{
                    compteur = 0;
                    alignement = false;
                }
            }
        }
        int cptVide = compteur;
        //ATTAQUE
        compteur = 0;
        while(alignement){
            for(int loop = 0; loop < c.length; loop++){
                if(etat == c[loop].getIntEtat()){
                    compteur++;
                }
                else{
                    compteur = 0;
                    alignement = false;
                }
            }
        }
        int cptAtt = compteur;
        //DEFENSE
        compteur = 0;
        while(alignement){
            for(int loop = 0; loop < c.length; loop++){
                if(c[loop].getIntEtat() != 0 && c[loop].getIntEtat() != etat){
                    compteur++;
                }
                else{
                    compteur = 0;
                    alignement = false;
                }
            }
        }
        int cptDef = compteur;
        
        //CALCUL DU SCORE
        int res = 0;
        if(cptAtt != 0 && cptDef == 0){
            res = calculScore(cptAtt);
        }
        else if(cptDef != 0 && cptAtt == 0){
            res = calculScore(cptDef);
        }
        else if(cptVide == p.getK())
            res = 1;
        else res = 0;
        return res;
    }

    public int indexCaseVide(Case[] c){
        int index = 0;
        for(int i = 0; i < c.length; i++){
            if(c[i].getIntEtat() == 0){
                index = i;
                i = c.length;
            }
        }
        return index;
    }

    public Case caseVide(Case [] c){
        Case vide = null;
        for(int i = 0; i < c.length; i++){
            if(c[i].getIntEtat()==0){
                vide = c[i];
            }
        }
        return vide;
    }

    public int calculScore(int cpt){
        int res = 0;
        switch (cpt) {
            case 1 :
                res = 2;
                break;
            case 2 : 
                if(p.getScan().equals("Morpion")){
                    res = 11;
                    //c[caseVide(c)].setScore(res);
                }
                res = 4;
                break;
            case 3 :
                if(p.getScan().equals("Puissance4")){
                    res = 11;
                    //c[caseVide(c)].setScore(res);
                }
                else res = 6;
                break;
            case 4 :
                if(p.getScan().equals("Gomoku")){
                    res = 11;
                    //c[caseVide(this.c)].setScore(res);
                }
                break;
        }
        return res;
    }*/

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