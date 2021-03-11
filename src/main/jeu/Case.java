package main.jeu;

public class Case {
    private char etat;
    private kuplet li;

    Case(char etat){
        this.etat = etat;
    }

    public char getEtat() {
        return etat;
    }

    public void setEtat(char etat) {
        this.etat = etat;
    }

    public kuplet getLi() {
        return li;
    }

    public void setLi(kuplet li) {
        this.li = li;
    }

    
}
