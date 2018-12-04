package model;

public class Board {
    private CellSet[][] cells;
    private int width;
    private int height;

    public Board(CellSet[][] cells, int width, int height) {
        this.cells = cells;
        this.width = width;
        this.height = height;
    }

    public void changeCellColor(int row, int column, Color color){
        cells[row][column].setColor(color);
    }
}
