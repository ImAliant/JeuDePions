package main.pawngame.player.human;

import main.pawngame.board.Board;
import main.pawngame.board.ConnectFourBoard;

public class ConnectFourHuman extends Human {

    public ConnectFourHuman(String name, int color) {
        super(name, color);
    }

    @Override
    public void play(Board board) {
        int col;
        do {
            System.out.println("Enter column [0..6]: ");
            col = scanner.nextInt();
        } while (!board.isLegalMove(((ConnectFourBoard) board).findRow(col), col));

        board.makeMove(((ConnectFourBoard) board).findRow(col), col, this);
    }
    
}
