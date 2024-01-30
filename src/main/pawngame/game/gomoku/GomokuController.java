package main.pawngame.game.gomoku;

import main.pawngame.game.Controller;

public class GomokuController extends Controller {
    public GomokuController() {
        super(new GomokuModel(), new GomokuView());
    }
}
