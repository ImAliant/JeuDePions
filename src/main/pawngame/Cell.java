package main.pawngame;

import java.util.ArrayList;
import java.util.List;

public class Cell {
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

    public void init() {
        kuplets = new ArrayList<>();
        for (Kuplet kuplet : board.getKuplets()) {
            if (kuplet.getCases().contains(this)) kuplets.add(kuplet);
        }
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

    public String state() {
        if (value == 0) return ".";
        else if (value == 1) return "X";
        else return "O";
    }

    @Override
    public String toString() {
        return String.format("(%d %d)", x, y);
    }

    public void setValue(int value) { 
        if (this.value == 0) {
            this.value = value;
        }
    }

    public List<Kuplet> getKuplets() { return kuplets; }
    public int getValue() { return value; }
    public int getX() { return x; }
    public int getY() { return y; }
    public int getScore() { return score; }
}
