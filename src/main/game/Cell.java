package main.game;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Cloneable {
    private Board board;

    private ArrayList<Kuplet> kuplets;
    private int value;
    private int score;

    private int x;
    private int y;

    public Cell(Board board, int value, int x, int y) {
        this.board = board;
        this.value = value;
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    @Override
    public Cell clone() {
        return new Cell(board.clone(), value, x, y);
    }

    public List<Kuplet> init() {
        ArrayList<Kuplet> res = new ArrayList<>();
        for (Kuplet kuplet : kuplets) {
            if (kuplet.contains(this)) res.add(kuplet);
        }
        return res;
    }

    public int score() {
        if (value != 0) score = 0;
        else {
            int scr = 0;
            for (Kuplet kuplet : kuplets) {
                scr += kuplet.getScore();
            }
            score = scr;
        }
        return score;
    }

    @Override
    public String toString() {
        String res;
        if (value == 0) res = ".";
        else if (value == 1) res = "X";
        else res = "O";
        return res;
    }

    public void setValue(int value) { 
        if (this.value == 0) {
            this.value = value;
        }
    }

    public int getValue() { return value; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getScore() { return score; }
}
