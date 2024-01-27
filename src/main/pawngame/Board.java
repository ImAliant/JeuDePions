package main.pawngame;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private int kuplet;
    private int row;
    private int column;

    private Cell[][] cells;

    private ArrayList<Kuplet> kuplets;

    public Board(GameConfigurations config) {
        this.kuplet = config.getKupletSize();
        this.row = config.getRow();
        this.column = config.getColumn();

        cells = new Cell[row][column];
        initCells();

        kuplets = new ArrayList<>();
        initKuplet();
    }

    private void initCells() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++)
                cells[i][j] = new Cell(this, 0, i, j);
        }
    }

    private void initKuplet() {
        initKupletH();
        initKupletV();
        initKupletD();

        initKupletCases();
    }

    private void initKupletH() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j <= column - kuplet; j++)
                kuplets.add(new Kuplet(this, getCellGroup(i, j, 0, 1)));
        }
    }

    private void initKupletV() {
        for (int i = 0; i < column; i++) {
            for (int j = 0; j <= row - kuplet; j++) {
                kuplets.add(new Kuplet(this, getCellGroup(j, i, 1, 0)));
            }
        }
    }

    private void initKupletD() {
        initKupletDHGBD();

        initKupletDHDBG();
    }

    private void initKupletDHGBD() {
        for (int i = 0; i <= row - kuplet; i++) {
            for (int j = 0; j <= column - kuplet; j++) {
                kuplets.add(new Kuplet(this, getCellGroup(i, j, 1, 1)));
            }
        }
    }

    private void initKupletDHDBG() {
        for (int i = kuplet - 1; i < row; i++) {
            for (int j = 0; j <= column - kuplet; j++) {
                kuplets.add(new Kuplet(this, getCellGroup(i, j, -1, 1)));
            }
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

        for (int i = 0; i < kuplet; i++) {
            group.add(cells[startX][startY]);
            startX += dirX;
            startY += dirY;
        }
            
        return group;
    }

    public int getKuplet() { return kuplet; }
    public int getColumn() { return column; }
    public int getRow() { return row; }
    public Cell[][] getCells() { return cells; }
    public List<Kuplet> getKuplets() { return kuplets; }
}
