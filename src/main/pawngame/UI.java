package main.pawngame;

import main.pawngame.board.Board;

public interface UI {
    public void printColumnNumbers(int column);
    public void printBorder();
    public void printBoardRepresentation(Board board);
    public void printOffset();
}
