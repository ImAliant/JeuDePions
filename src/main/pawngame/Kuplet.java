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

    public void updateScore() {
        int b = countPawns(Constants.COLORP1);
        int w = countPawns(Constants.COLORP2);
        
        score = 0;

        if (b == 0 && w != 0) score = calculateScore(w, 35);
        else if (w == 0 && b != 0) score = calculateScore(b, 15);
    }

    private int countPawns(int color) {
        int count = 0;
        for (Cell cell : cases) {
            if (cell.getValue() == color) count++;
        }
        return count;
    }

    private int calculateScore(int count, int multiplier) {
        for (int i = 1; i <= cases.size(); i++) {
            if (count == i) {
                return (int) (multiplier*Math.pow(10, count));
            }
        }
        return 0;
    }

    public boolean isFullOf(int color) {
        for (Cell cell : cases) {
            if (cell.getValue() != color) return false;
        }
        return true;
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
