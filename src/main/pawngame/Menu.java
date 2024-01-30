package main.pawngame;

import java.util.Scanner;

import main.pawngame.game.*;
import main.pawngame.game.connectfour.*;
import main.pawngame.game.gomoku.*;
import main.pawngame.game.tictactoe.*;

public class Menu {
    protected final Scanner scanner = new Scanner(System.in);

    private int game;

    public Menu() {
        run();
    }

    private void run() {
        clearScreen();

        welcomeMessage();

        askForGame();

        launchGame();
    }

    private void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    private void welcomeMessage() {
        System.out.printf("%s %n", Constants.WELCOME);
    }

    private void askForGame() {
        for (Tuple<Integer, String> g : Constants.GAMES)
            System.out.println(String.format("%d. %s", g.getFirst(), g.getSecond()));
        System.out.printf("%s ", Constants.GAMEQUESTION);
        String rep = scanner.nextLine();

        if (rep.isEmpty())
            rep = Constants.DEFAULTGAME;
        
        while (!rep.matches(Constants.NUMBERREGEX) || Integer.parseInt(rep) < 1 || Integer.parseInt(rep) > 3) {
            System.out.printf("%s ", Constants.INVALIDGAME);
            rep = scanner.nextLine();
        }

        game = Integer.parseInt(rep);

        System.out.println();
    }

    private void launchGame() {
        Game newGame;
        
        switch (game) {
            case Constants.TICTACTOE:
                newGame = new Tictactoe(new TictactoeController());
                break;
            case Constants.CONNECTFOUR:
                newGame = new ConnectFour(new ConnectFourController());
                break;
            case Constants.GOMOKU:
                newGame = new Gomoku(new GomokuController());
                break;
            default:
                throw new IllegalArgumentException(Constants.INVALIDGAME);
        }

        newGame.start();
    }
}
