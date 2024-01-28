package main.pawngame.player.ai;

import main.pawngame.Constants;
import main.pawngame.player.Player;

public abstract class AI extends Player{
    protected AI(int color) {
        super(Constants.AI, color);
    }
}
