package main.jeu;

import java.util.ArrayList;

/**
 * <b>Case est la classe représentant une case faisant partie d'un plateau.</b>
 * <p>
 * Une case est caractérisé par les informations suivantes :
 * <ul>
 * <li> Une liste de k-uplet où la case est présente.</li>
 * <li> Un état, il peut être vide (0), noir (1), blanc (2).</li>
 * <li> Un score, par défaut égal à 1.</li>
 * <li> Une coordonnée x.</li>
 * <li> Une coordonnée y.</li>
 * </ul>
 * 
 * @see kuplet
 * 
 * @author Alexandre, Aymen, Mouadh, Riad
 */
public class Case {

    /**
     * La liste de kuplet de la case. Cette liste est composée par tout les k-uplets où la case est présente.
     * 
     * @see kuplet
     * 
     * @see Case#getLi()
     */
    private ArrayList<kuplet> li;

    /**
     * L'état de la case. Cette état est changeable une seule fois.
     * 
     * @see Case#getEtat()
     * @see Case#setEtat(int)
     */
    private int etat;

    /**
     * Le score de la case. Ce score est donné en additionnant le score de tout les k-uplets présents dans la liste.
     * 
     * @see kuplet
     * 
     * @see Case#getScore()
     * @see Case#setScore(int)
     */
    private int score;

    /**
     * La coordonnée x de la case. Elle correspond à la colonne du plateau où se trouve la case.
     * 
     * @see Plateau
     * 
     * @see Case#getX()
     * @see Case#setX(int)
     */
    private int x;

    /**
     * La coordonnée y de la case. Elle correspond à la ligne du plateau où se trouve la case.
     * 
     * @see Plateau
     * 
     * @see Case#getY()
     * @see Case#setY(int)
     */
    private int y;

    /**
     * Constructeur Case.
     * <p>
     * A la construction d'un objet Case, l'état est fixé à 0, ce qui correspond à
     * vide.
     * </p>
     * @param etat
     *      L'état de la Case.
     * @param x
     *      La coordonnée x de la Case.
     * @param y
     *      La coordonnée y de la Case.
     * @param li
     *      La liste de k-uplets de la Case.
     * 
     * @see Case#etat
     * @see Case#x
     * @see Case#y
     * @see Case#li
     * @see Case#score
     */
    public Case(int etat, int x, int y, ArrayList<kuplet> li){
        this.etat = etat;
        this.x = x;
        this.y = y; 
        this.li = li;
        this.score = 1;
    }    
    
    /**
     * Initialise la liste des k-uplets de la case.
     * 
     * @param p
     *      Le Plateau.
     * @return La liste des k-uplets.
     * 
     * @see Case#li
     */
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

    /**
     * Calcul le score de la case.
     * @return Le score de la case.
     * 
     * @see Case#score
     */
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

    /**
     * Retourne l'état en entier.
     * @return L'état de la case.
     */
    public int getIntEtat(){
        return etat;
    }

    /**
     * Retourne l'état en caractère.
     * @return L'état de la case.
     */
    public char getEtat() {
        if(etat == 1){
            return 'X';
        }
        if(etat == 2){
            return 'O';
        }
        else return '.';
    }

    /**
     * Met à jour l'état de la case.
     * @param etat
     *      Le nouvel état de la case.
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     * Retourne la liste de k-uplets.
     * @return La liste de k-uplets
     * 
     * @see kuplet
     */
    public ArrayList<kuplet> getLi() {
        return li;
    }

    /**
     * Met à jour la liste des k-uplets de la case.
     * @param li
     *      La nouvelle liste de k-uplets.
     * 
     * @see kuplet
     */
    public void setLi(ArrayList<kuplet> li) {
        this.li = li;
    }

    /**
     * Retourne la coordonnée x de la case.
     * @return La coordonnée x.
     */
    public int getX() {
        return x;
    }

    /**
     * Met à jour la coordonnée x de la case.
     * @param x
     *      La nouvelle coordonnée x de la case.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Retourne la coordonnée y de la case.
     * @return La coordonnée y.
     */
    public int getY() {
        return y;
    }

    /**
     * Met à jour la coordonnée y de la case.
     * @param y
     *      La nouvelle coordonnée y de la case.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Retourne le score de la case.
     * @return Le score de la case.
     */
    public int getScore() {
        return score;
    }

    /**
     * Met à jour le score de la case.
     * @param score
     *      Le nouveau score de la case.
     */
    public void setScore(int score) {
        this.score = score;
    }  
}