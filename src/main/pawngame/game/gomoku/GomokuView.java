package main.pawngame.game.gomoku;

import main.pawngame.board.Board;
import main.pawngame.game.View;

public class GomokuView extends View {

    @Override
    public void printColumnNumbers(int column) {
        printOffset();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, charValue = 65; i < column; i++)
            sb.append((char) (charValue + i)).append(" ");
        System.out.println(sb);
    }

    @Override
    public void printBorder() {
        System.out.println("  +---------------------------------------+");                   
    }

    @Override
    public void printBoardRepresentation(Board board) {
        int rows = board.getRow();
        int columns = board.getColumn();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, charValue = 65; i < rows; i++) {
            sb.append((char) (charValue + i)).append(" | ");
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
