package main.game;

import java.util.ArrayList;
import java.util.List;

public class Kuplet {
    private Board board;
    private int score;
    private ArrayList<Cell> cases;

    public Kuplet(Board board, List<Cell> cases) {
        this.board = board;
        this.score = 0;
        this.cases = new ArrayList<>(cases);
    }

    public boolean contains (Object o) {
        return cases.contains(o);
    }

    public Board getBoard() { 
        return board.clone();
    }
    public int getScore() { return score; }
    public List<Cell> getCases() { 
        return new ArrayList<>(cases); 
    }
}
