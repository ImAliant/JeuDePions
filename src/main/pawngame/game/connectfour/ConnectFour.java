package main.pawngame.game.connectfour;

import main.pawngame.GameConfigurations;
import main.pawngame.Player;
import main.pawngame.game.Model;

public class ConnectFour extends Model {
    public ConnectFour(Player[] players, GameConfigurations gameConfigurations) {
        super(players, gameConfigurations);
    }

    @Override
    protected void checkBoardDimension() {
        if (board.getColumn() != 7 || board.getRow() != 6)
            throw new IllegalArgumentException("Connect Four board must be 7x6");
    }
}
