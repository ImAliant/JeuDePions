package main.pawngame.player;

import main.pawngame.Board;

public abstract class Player {
    private static int ID = 0;

    protected String name;
    protected int id;

    protected Player(String name) {
        this.name = name;
        id = ID;
        
        ID++;
    }

    public abstract void play(Board board);

    public int getId() { return id; }
    public String getName() { return name; }
}
