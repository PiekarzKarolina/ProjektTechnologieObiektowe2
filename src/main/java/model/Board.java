package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private ArrayList<ArrayList<Cell>> cells;
    private int width;
    private int height;

    public Board(ArrayList<ArrayList<Cell>> cells, int width, int height) {
        this.cells = cells;
        this.width = width;
        this.height = height;
    }

    public void changeCellColor(int row, int column, Color color) {
        if(cells.get(row).get(column) instanceof  CellSet) cells.get(row).get(column).setColor(color);
    }

    private List<CellSet> validate() {
        //TODO
        return null;
    }


}
