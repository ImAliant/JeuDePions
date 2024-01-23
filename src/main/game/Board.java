package main.game;

import java.util.ArrayList;
import java.util.List;

public class Board implements Cloneable{
    private int kuplet;
    private int column;
    private int row;

    private Cell[][] cells;

    private ArrayList<Kuplet> kuplets;

    public Board(int kuplet, int column, int row) {
        this.kuplet = kuplet;
        this.column = column;
        this.row = row;

        cells = new Cell[column][row];

        kuplets = new ArrayList<>();

        initKuplet();
    }

    private void initKuplet() {
        initKupletH();
        initKupletV();
        initKupletD();
    
        initKupletCases();
    }

    private void initKupletH() {
        for (int j = 0; j < row; j++)
            for (int i = 0; i <= column - kuplet + 1; i++)
                kuplets.add(new Kuplet(this, getCellGroup(i, j, 0, 1)));
    }

    private void initKupletV() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j <= row - kuplet; j++)
                kuplets.add(new Kuplet(this, getCellGroup(i, j, 1, 0)));
        }
    }

    private void initKupletD() {
        initKupletD1();

        initKupletD2();
    }

    private void initKupletD1() {
        for (int i = 0; i <= column - kuplet; i++) {
            for (int j = 0; j <= row - kuplet; j++)
                kuplets.add(new Kuplet(this, getCellGroup(i, j, 1, 1)));
        }
    }

    private void initKupletD2() {
        for (int i = kuplet - 1; i < column; i++) {
            for (int j = 0; j <= row - kuplet; j++)
                kuplets.add(new Kuplet(this, getCellGroup(i, j, -1, 1)));
        }
    }

    private void initKupletCases() {
        for (Kuplet k : kuplets) {
            for (Cell cell : k.getCases())
                cell.init();
        }
    }

    public List<Cell> getCellGroup(int startX, int startY, int dirX, int dirY) {
        ArrayList<Cell> group = new ArrayList<>();

        for (int i = 0; i < kuplet; i++)
            group.add(cells[startX + i * dirX][startY + i * dirY]);

        return group;
    }

    @Override
    public Board clone() {
        Board clone = new Board(kuplet, column, row);

        for (int i = 0; i < column; i++) {
            for (int j = 0; j < row; j++)
                clone.cells[i][j] = cells[i][j].clone();
        }

        return clone;
    }

    public int getKuplet() { return kuplet; }
    public int getColumn() { return column; }
    public int getRow() { return row; }
}
