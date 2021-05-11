package main.jeu;

public class Jeu {
    private Plateau p;
    public static Joueur[] joueurs =new Joueur[2];
    
    Jeu(Joueur j1, Joueur j2){
        joueurs[0] = j1;
        joueurs[1] = j2;
        p =new Plateau();
    }

    public void joue(){
        int vainqueur = -1;
        int tourJoueur = 0;
        int tour = 1;

        p.affichagePlateau();

        while(vainqueur == -1){
            System.out.println("Tour " + tour + ", Etat du plateau :");
            System.out.println();

            joueurs[tourJoueur].joue(p);
            p.affichagePlateau();


            if(p.victoire()){
                vainqueur = tourJoueur;
            }

            if(p.estPlein()){
                vainqueur = 3;
            }

            tourJoueur++;
            tourJoueur %= 2;
            tour++;

            for(int i = 0; i < p.getListKu().size(); i++){
                p.getListKu().get(i).score();
            }
            for(int i = 0; i < p.getCases().length; i++){
                for(int j = 0; j < p.getCases()[i].length; j++){
                    p.getCases()[i][j].score();
                }
            }

            //p.afficheKuplets(p.getListKu());
        }

        System.out.println("FIN DE PARTIE");
        p.affichagePlateau();
        if(vainqueur == 3){
            System.out.println("MATCH NUL");
        }
        else{
            String sNom = joueurs[vainqueur].getNom().toUpperCase();
            System.out.println(sNom + " A GAGNE LA PARTIE");
        }
    }

    public Plateau getP() {
        return p;
    }

    public void setP(Plateau p) {
        this.p = p;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }
}

