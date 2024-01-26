package main.pawngame;

public class Player {
    private static int ID = 0;

    private String name;
    private int id;

    public Player(String name) {
        this.name = name;
        id = ID;
        
        ID++;
    }

    public String getName() { return name; }
}
