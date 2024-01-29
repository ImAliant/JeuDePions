package main.pawngame.player.human;

import main.pawngame.board.Board;

public class GomokuHuman extends Human {

    public GomokuHuman(String name, int color) {
        super(name, color);
    }

    @Override
    public void play(Board board) {
        int[] move;
        int row;
        int col;
        do {
            move = getMove();
            row = move[0];
            col = move[1];
        } while (!board.isLegalMove(row, col));
        board.makeMove(row, col, this);
    }

    private int[] getMove() {
        while(true) {
            System.out.println("Enter move [A..S]: ");
            String in = scanner.nextLine();
            String[] parts = in.split("\\s");
            if (parts.length == 2) {
                return new int[]{stringToInt(parts[0]), stringToInt(parts[1])};
            }
            System.out.println("Invalid input format. Please enter move in the format 'A S'.");
        }
    }

    private int stringToInt(String s) {
        return s.charAt(0) - 'A';
    }
}
