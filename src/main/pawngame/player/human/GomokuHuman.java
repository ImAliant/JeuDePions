package main.pawngame.player.human;

import main.pawngame.board.Board;

public class GomokuHuman extends Human {

    public GomokuHuman(String name, int color) {
        super(name, color);
    }

    @Override
    public void play(Board board) {
        int row;
        int col;
        do {
            System.out.println("Enter row [A..S]: ");
            row = stringToInt(scanner.nextLine());
            System.out.println("Enter column [A..S]: ");
            col = stringToInt(scanner.nextLine());
        } while (!board.isLegalMove(row, col));
        board.makeMove(row, col, this);
    }

    private int stringToInt(String s) {
        return s.charAt(0) - 'A';
    }
}
