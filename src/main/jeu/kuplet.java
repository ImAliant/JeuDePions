package main.jeu;

/**
 * <b>kuplet est la classe représentant un k-uplet faisant partie d'un plateau.</b>
 * <p>
 * Un kuplet est caractérisé par les informations suivantes :
 * <ul>
 * <li> Un plateau, où le kuplet est présent.</li>
 * <li> Un score, par défaut égal à 7.</li>
 * <li> Un tableau de Case, de taille K.</li>
 * </ul>
 * 
 * @see Plateau
 * @see Case
 * 
 * @see Plateau#getK()
 * 
 * @author Alexandre, Aymen, Mouadh, Riad
 */
public class kuplet{

    /**
     * Le plateau où est présent le kuplet.
     * 
     * @see Plateau
     * 
     * @see kuplet#getP()
     * @see kuplet#setP(Plateau)
     */
	private Plateau p;

    /**
     * Le score du kuplet. Il est donné en fonction du nombre de pions 
     * de la même couleur présent dans le kuplet.
     * 
     * @see kuplet#getScore()
     * @see kuplet#setScore(int) 
     */
    private int score;
    /**
     * Le tableau de Case du kuplet. Ce tableau est de taille K correspondant
     * a l'alignement nécessaire pour gagné la partie.
     * 
     * @see kuplet#getC()
     * @see kuplet#setC(Case[])
     * 
     * @see Plateau#getK()
     */
    private Case[] c;

    /**
     * Constructeur kuplet.
     * <p>
     * A la construction d'un objet kuplet, le tableau de Case est null
     * et le score est fixé par défaut à 7.
     * </p>
     * @param p
     *      Le plateau où se trouve le kuplet.
     * @param c
     *      Le tableau de Case du kuplet.
     * 
     * @see kuplet#p
     * @see kuplet#c
     * @see kuplet#score
     * 
     * @see Case
     */
    public kuplet(Plateau p, Case[] c){
        this.p = p;
        this.c = c;
        this.score = 7;
    }

    /**
     * Calcul le score du kuplet. Le score est donné en fonction du 
     * nombre de pions de mêmes couleurs dans le kuplet. Si il y a plus
     * d'un pion de différentes couleurs dans un kuplet le score est 
     * égale à 0.
     * @return Le score du kuplet.
     * 
     * @see kuplet#score
     * @see kuplet#countEtat(char)
     * 
     * @see Plateau
     * @see Plateau#getK()
     */
    public int score() {
        int x=countEtat('X');
        int y=countEtat('O');
        if(x>=1 && y>=1) {
            score=0;
            return score;
        }
        if(x==0 && y>=1){
            for(int i = 1; i < p.getK(); i++){
                if(y==i){
                    score = (int) (35*Math.pow(10, y));
                }
            }
        }
        else if(x>=1 && y==0){
            for(int i = 1; i < p.getK(); i++){
                if(x==i){
                    score = (int) (15*Math.pow(10, x));
                }
            }
        }
        return score;
    }

    /**
     * Compte le nombre de pions d'une certaine couleur dans le kuplet.
     * @param etat
     *      L'état que l'on veut compter.
     * @return Le nombre de pions de cette couleur.
     * 
     * @see kuplet#getC()
     */
    public int countEtat(char etat) {
    	int cpt=0;
    	for(int i=0;i<getC().length; i++) {
    		if(c[i].getEtat()==etat) {
    			cpt++;
    		}
    	}
    	return cpt;
    }

    /**
     * Retourne le plateau.
     * @return Le plateau.
     */
    public Plateau getP() {
        return p;
    }

    /**
     * Met à jour le plateau.
     * @param p
     *      Le nouveau plateau.
     */
    public void setP(Plateau p) {
        this.p = p;
    }

    /**
     * Retourne le score du kuplet.
     * @return Le score du kuplet.
     */
    public int getScore() {
        return score;
    }

    /**
     * Met à jour le score du kuplet.
     * @param score
     *      Le nouveau score du kuplet.
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * Retourne le tableau de Case du kuplet.
     * @return Le tableau de Case du kuplet.
     * 
     * @see Case
     */
    public Case[] getC() {
        return c;
    }

    /**
     * Met à jour le tableau de Case du kuplet.
     * @param c
     *      Le nouveau tableau de Case du kuplet.
     */
    public void setC(Case[] c) {
        this.c = c;
    }
}