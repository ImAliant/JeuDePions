package main.pawngame.player.human;

import main.pawngame.board.Board;
import main.pawngame.board.ConnectFourBoard;

public class ConnectFourHuman extends Human {

    public ConnectFourHuman(String name, int color) {
        super(name, color);
    }

    @Override
    public void play(Board board) {
        int row;
        int col;
        do {
            System.out.println("Enter column [0..6]: ");
            col = scanner.nextInt();
            row = ((ConnectFourBoard) board).findRow(col);
        } while (!board.isLegalMove(row, col));

        board.makeMove(row, col, this);
    }
    
}
