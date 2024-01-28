package main.pawngame.player.human;

import main.pawngame.board.Board;

public class TictactoeHuman extends Human {

    public TictactoeHuman(String name, int color) {
        super(name, color);
    }

    @Override
    public void play(Board board) {
        int row;
        int col;
        do {
            System.out.println("Enter row and column [0..2]: ");
            row = scanner.nextInt();
            col = scanner.nextInt();
        } while (!board.isLegalMove(row, col));
        board.makeMove(row, col, this);
    }
    
}
