package main.pawngame.game;

import main.pawngame.Constants;
import main.pawngame.GameConfigurations;
import main.pawngame.board.Board;
import main.pawngame.player.Player;

import java.util.Scanner;
import java.util.ArrayList;

public abstract class Model {
    protected Scanner scanner = new Scanner(System.in);

    protected Board board;
    protected ArrayList<Player> players;

    protected Player currentPlayer;
    private Player winner;

    protected boolean playerChanged = false;

    public void init() {
        initPlayers();
        initBoard();
    }

    private void initPlayers() {
        // we ask the user if he wants to play with a friend or with the computer
        boolean ai = askForAI();
        // we create the players
        players = new ArrayList<>();
        createPlayers(ai);
        // we set the current player to the first player
        currentPlayer = players.get(0);
    }

    private void initBoard() {
        createConfig();

        int row = board.getRow();
        int column = board.getColumn();

        checkBoardDimension(row, column);
    }

    public void turn() {
        currentPlayer.play(board);
    }

    protected void changePlayer() {
        int id = currentPlayer.getId();
        currentPlayer = players.get((id + 1) % players.size());
    }

    private boolean askForAI() {
        boolean ai = Constants.DEFAULTAI;

        System.out.printf("%s ", Constants.AIQUESTION);
        String rep = scanner.nextLine();
        if (!rep.equals(Constants.YES) && !rep.equals(Constants.NO) && !rep.isEmpty())
            throw new IllegalArgumentException(Constants.INVALIDANSWER);
        
        if (rep.equals(Constants.NO)) ai = false;
        System.out.println();

        return ai;
    }

    protected boolean checkWin() {
        winner = currentPlayer;

        return false;
    }

    public Board getBoard() {
        return board;
    }
    public Player getCurrentPlayer() {
        return currentPlayer;
    }
    public Player getWinner() {
        return winner;
    }

    protected abstract void createPlayers(boolean ai);
    protected abstract void createConfig();
    protected abstract void checkBoardDimension(int row, int column);
    protected abstract void checkBoardDimension();
}