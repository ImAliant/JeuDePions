package main.pawngame.game.tictactoe;

import main.pawngame.Board;
import main.pawngame.game.View;

public class TictactoeView extends View {

    @Override
    public void printColumnNumbers(int column) {
        printOffset();
        super.printColumnNumbers(column);
    }

    @Override
    public void printBorder() {
        System.out.println("  +-------+");
    }

    @Override
    public void printBoardRepresentation(Board board) {
        int rows = board.getRow();
        int columns = board.getColumn();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append(i).append(" | ");
            for (int j = 0; j < columns; j++) {
                sb.append(board.getCells()[i][j].state()).append(" ");
            }
            sb.append("|\n");
        }
        System.out.print(sb);
    }
    
    @Override
    public void printOffset() {
        System.out.print("    ");
    }
}
