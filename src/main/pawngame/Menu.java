package main.pawngame;

import java.util.Scanner;

import main.pawngame.game.*;
import main.pawngame.game.connectfour.*;
import main.pawngame.game.gomoku.*;
import main.pawngame.game.tictactoe.*;

public class Menu {
    protected final Scanner scanner = new Scanner(System.in);

    private int game;
    private String ai;

    public Menu() {
        run();
    }

    private void run() {
        clearScreen();

        welcomeMessage();

        askForGame();

        askForAI();

        launchGame();
    }

    // TODO set this function in a specific class
    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void welcomeMessage() {
        System.out.printf("%s \n", Constants.WELCOME);
    }

    private void askForGame() {
        for (Tuple<Integer, String> g : Constants.GAMES)
            System.out.println(String.format("%d. %s", g.getFirst(), g.getSecond()));
        System.out.printf("%s ", Constants.GAMEQUESTION);
        String rep = scanner.nextLine();

        if (rep.isEmpty())
            rep = Constants.DEFAULTGAME;
        if (Integer.parseInt(rep) < 1 || Integer.parseInt(rep) > Constants.GAMES.size()+1)
            throw new IllegalArgumentException(Constants.INVALIDGAME);

        game = Integer.parseInt(rep);

        System.out.println();
    }

    private void askForAI() {
        System.out.printf("%s ", Constants.AIQUESTION);
        ai = scanner.nextLine();

        if (!ai.equals(Constants.YES) && !ai.equals(Constants.NO) && !ai.isEmpty())
            throw new IllegalArgumentException(Constants.INVALIDANSWER);

        if (ai.isEmpty()) 
            ai = Constants.DEFAULTAI;

        System.out.println();
    }

    private void launchGame() {
        Player[] players = new Player[Constants.MAX_PLAYERS];
        players[Constants.IDPLAYER1] = new Human(Constants.FIRSTPLAYER);
        if (ai.equals(Constants.YES))
            players[Constants.IDPLAYER2] = new AI(Constants.AI);
        else players[Constants.IDPLAYER2] = new Human(Constants.SECONDPLAYER);

        Controller newGame;
        
        switch (game) {
            case Constants.TICTACTOE:
                newGame = new TictactoeController(new Tictactoe(players), new TictactoeView());
                break;
            case Constants.CONNECTFOUR:
                newGame = new ConnectFourController(new ConnectFour(players), new ConnectFourView());
                break;
            case Constants.GOMOKU:
                newGame = new GomokuController(new Gomoku(players), new GomokuView());
                break;
            default:
                throw new IllegalArgumentException(Constants.INVALIDGAME);
        }

        newGame.start();
    }
}
