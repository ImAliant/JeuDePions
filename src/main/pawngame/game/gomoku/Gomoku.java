package main.pawngame.game.gomoku;

import main.pawngame.GameConfigurations;
import main.pawngame.Player;
import main.pawngame.game.Model;

public class Gomoku extends Model {
    public Gomoku(Player[] players, GameConfigurations gameConfigurations) {
        super(players, gameConfigurations);
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 19 || board.getRow() != 19)
            throw new IllegalArgumentException("Gomoku board must be 19x19");
    }
}
