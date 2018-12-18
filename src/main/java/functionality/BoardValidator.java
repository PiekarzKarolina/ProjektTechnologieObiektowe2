package functionality;

import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class BoardValidator {

    //returns list od invalid cells or empty list if current solution is equal to expected
    List<Cell> validate(Board expected, Board current) {
        List<Cell> invalidCells = new ArrayList<>();
        int rows = expected.getHeight();
        int colums = expected.getWidth();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < colums; c++) {
                if (!expected.getCell(r, c).equals(current.getCell(r, c)))
                    invalidCells.add(current.getCell(r, c));
            }
        }
        return invalidCells;
    }
}
