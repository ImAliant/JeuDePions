package main.jeu;

public class Case {
    private char etat;
    private k_uplet li;

    Case(char etat){
        this.etat = etat;
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

    public k_uplet getLi() {
        return li;
    }

    public void setLi(k_uplet li) {
        this.li = li;
    }

    
}
