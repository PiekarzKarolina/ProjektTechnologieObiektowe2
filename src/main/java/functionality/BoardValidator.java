package functionality;

import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class BoardValidator {
    private boolean solved = true;
    private final Cell[][] diff;

    public BoardValidator(Board expected, Board current) {
        this.diff = this.validate(expected, current);
    }

    private Cell[][] validate(Board expected, Board current) {
        int rows = expected.getHeight();
        int colums = expected.getWidth();
        Cell[][] invalidCells = new Cell[rows][colums];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colums; c++) {
                if (!expected.getCell(r, c).equals(current.getCell(r, c))) {
                    invalidCells[r][c] = current.getCell(r, c);
                    solved = false;
                }
            }
        }
        return invalidCells;
    }

    public boolean isSolved() {
        return solved;
    }

    public Cell[][] getDiff() {
        return diff;
    }
}
