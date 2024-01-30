package main.pawngame.game.tictactoe;

import main.pawngame.game.Controller;

public class TictactoeController extends Controller{

    public TictactoeController() {
        super(new TictactoeModel(), new TictactoeView());
    }
    
}
