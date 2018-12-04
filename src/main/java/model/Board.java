package model;

public class Board {
    private final CellSet[][] cells;
    private final int width;
    private final int height;

    public Board(int height, int width) {
        this.height = height;
        this.width = width;

        cells = new CellSet[height][width];
    }
}
