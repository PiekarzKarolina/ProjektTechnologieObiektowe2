package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Cell[][] cells;
    private int width;
    private int height;

    public Board(Cell[][] cells, int width, int height) {
        this.cells = cells;
        this.width = width;
        this.height = height;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void changeCellColor(int row, int column, Color color) {
       cells[row][column].setColor(color);
    }

    private List<Cell> validate() {
        //TODO
        return null;
    }


}
