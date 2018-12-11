package functionality;

import model.Board;
import model.Cell;

import java.util.ArrayList;
import java.util.List;

public class BoardValidator {

    //returns list od invalid cells or empty list if current solution is equal to expected
    List<Cell> validate (Board expected, Board current){
        List<Cell> invalidCells = new ArrayList<>();
        int rows = expected.getHeight();
        int colums = expected.getWidth();
        Cell[][] expectedCells = expected.getCells();
        Cell[][] currentCells = current.getCells();

        for (int r=0; r< rows; r++){
            for (int c=0; c< colums; c++){
                if (!expectedCells[r][c].equals(currentCells[r][c]))
                    invalidCells.add(currentCells[r][c]);
            }
        }
        return invalidCells;
    }
}
