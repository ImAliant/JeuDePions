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
            col = bestMove.getX();
            row = ((ConnectFourBoard) board).findRow(col);
        } while (!board.isLegalMove(row, col));

        board.makeMove(row, col, this);
    }
}
