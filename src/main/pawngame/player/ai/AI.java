package main.pawngame.player.ai;

import main.pawngame.Cell;
import main.pawngame.Constants;
import main.pawngame.board.Board;
import main.pawngame.player.Player;

public abstract class AI extends Player{
    protected AI(int color) {
        super(Constants.AI, color);
    }

    public void play(Board board) {
        int row;
        int col;
        do {
            Cell bestMove = board.findBestMove();
            row = bestMove.getX();
            col = bestMove.getY();

            if (row < 0 || row >= board.getRow())
                throw new IllegalArgumentException("Row is out of range");
            if (col < 0 || col >= board.getColumn())
                throw new IllegalArgumentException("Column is out of range");
        } while (!board.isLegalMove(row, col));
        board.makeMove(row, col, this);
    }
}
