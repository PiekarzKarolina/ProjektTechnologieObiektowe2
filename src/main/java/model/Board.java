package model;


public class Board {
    private final Cell[][] cells;

    public Board(Cell[][] cells) {
        this.cells = cells;
    }

    public Cell getCell(int i, int j) {
        return cells[i][j];
    }

    public int getWidth() {
        return cells.length;
    }

    public int getHeight() {
        return cells[0].length;
    }

    public Color getCellColor(int row, int column) {
        return cells[row][column].getColor();
    }

    public void setCellColor(int row, int column, Color color) {
        cells[row][column].setColor(color);
    }
}
