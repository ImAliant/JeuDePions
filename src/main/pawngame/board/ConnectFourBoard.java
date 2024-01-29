package main.pawngame.board;

import main.pawngame.Cell;
import main.pawngame.GameConfigurations;

public class ConnectFourBoard extends Board {

    public ConnectFourBoard(GameConfigurations config) {
        super(config);
    }

    public int findRow(int column) {
        int row = -1;

        if (isFull(column))
            throw new IllegalArgumentException("Column is full");
        if (column < 0 || column >= getColumn())
            throw new IllegalArgumentException("Column is out of range");

        for (int i = getRow() - 1; i >= 0; i--) {
            if (getCell(i, column).getValue() == 0) {
                row = i;
                break;
            }
        }

        return row;
    }
    
    public boolean isFull(int column) {
        if (column < 0 || column >= getColumn())
            throw new IllegalArgumentException("Column is out of range");
        
        return getCell(0, column).getValue() != 0;
    }
}
