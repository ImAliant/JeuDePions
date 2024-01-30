package main.pawngame.player;

import java.util.Scanner;

import main.pawngame.board.Board;

public abstract class Player {
    protected Scanner scanner = new Scanner(System.in);

    private static int ID = 0;

    protected String name;
    protected int id;
    protected int color;

    protected Player(String name, int color) {
        this.name = name;
        this.color = color;
        id = ID;
        
        ID++;
    }

    public abstract void play(Board board);

    public String getName() { return name; }
    public int getId() { return id; }
    public int getColor() { return color; }
}
