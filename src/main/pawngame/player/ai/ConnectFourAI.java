package main.pawngame.player.ai;

import main.pawngame.Cell;
import main.pawngame.board.Board;
import main.pawngame.board.ConnectFourBoard;

public class ConnectFourAI extends AI{
    public ConnectFourAI(int color) {
        super(color);
    }

    @Override
    public void play(Board board) {
        int row;
        int col;
        do {
            Cell bestMove = board.findBestMove();
            col = bestMove.getY();

            if (col < 0 || col >= board.getColumn())
                throw new IllegalArgumentException("Column is out of range");
        } while (((ConnectFourBoard) board).isFull(col));

        row = ((ConnectFourBoard) board).findRow(col);
        board.makeMove(row, col, this);
    }
}
