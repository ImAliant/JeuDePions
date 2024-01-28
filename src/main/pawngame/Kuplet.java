package main.pawngame;

import java.util.ArrayList;
import java.util.List;

import main.pawngame.board.Board;

public class Kuplet {
    private Board board;
    private int score;
    private ArrayList<Cell> cases;

    public Kuplet(Board board, List<Cell> cases) {
        this.board = board;
        this.score = 0;
        this.cases = new ArrayList<>(cases);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Cell cell : cases) {
            res.append(cell.toString());
            res.append(" ");
        }
        return res.toString();
    }

    public boolean contains (Object o) {
        return cases.contains(o);
    }

    public Board getBoard() { 
        return board;
    }
    public int getScore() { return score; }
    public List<Cell> getCases() { 
        return new ArrayList<>(cases); 
    }
}
