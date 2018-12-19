package functionality;

import model.Cell;
import model.Color;
import model.DoubleBoard;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BoardValidatorTest {

    @Test
    void validate() {
        //given
        BoardInitializer initializer = new BoardInitializer();
        BoardValidator validator = new BoardValidator();
        DoubleBoard doubleBoard = initializer.initializeBoard("easy_board1.csv");
        DoubleBoard doubleBoard2 = initializer.initializeBoard("board1.csv");
        DoubleBoard invalidBoard = initializer.initializeBoard("board_for_junit_only.csv"); //this board should actually contain invalid solution!

        Cell island1 = new Cell("1");
        Cell island2 = new Cell("2");
        Cell island3 = new Cell("3");
        Cell island4 = new Cell("4");
        Cell island5 = new Cell("5");
        Cell island6 = new Cell("6");
        Cell island7 = new Cell("7");

        Cell water = new  Cell(Color.BLACK);
        Cell partOfAnIsland = new Cell(Color.WHITE);


        //when
        List<Cell> invalidCells = validator.validate(doubleBoard.getFinalBoard(), doubleBoard.getUserBoard());
        List<Cell> emptyInvalidCells = validator.validate(doubleBoard.getFinalBoard(), doubleBoard.getFinalBoard());

        List<Cell> invalidCells2 = validator.validate(doubleBoard2.getFinalBoard(), doubleBoard2.getUserBoard());
        List<Cell> emptyInvalidCells2 = validator.validate(doubleBoard2.getFinalBoard(), doubleBoard2.getFinalBoard());

        List<Cell> invalidCells3 = validator.validate(doubleBoard.getFinalBoard(), invalidBoard.getFinalBoard());

                //then
        assertEquals(14, invalidCells.size());
        assertEquals(0, emptyInvalidCells.size());
        assertEquals(61, invalidCells2.size());
        assertEquals(0, emptyInvalidCells2.size());

        assertEquals(2, invalidCells3.size());

        assertFalse(invalidCells.contains(island1));    //islands-to-be should never be among invalid
        assertFalse(invalidCells.contains(island2));
        assertFalse(invalidCells.contains(island3));
        assertFalse(invalidCells.contains(island4));
        assertFalse(invalidCells.contains(island5));
        assertFalse(invalidCells.contains(island6));
        assertFalse(invalidCells.contains(island7));
        assertFalse(invalidCells2.contains(island1));
        assertFalse(invalidCells2.contains(island2));
        assertFalse(invalidCells2.contains(island3));
        assertFalse(invalidCells2.contains(island4));
        assertFalse(invalidCells2.contains(island5));
        assertFalse(invalidCells2.contains(island6));
        assertFalse(invalidCells2.contains(island7));

        assertTrue(invalidCells3.contains(water));
        assertTrue(invalidCells3.contains(partOfAnIsland));     //unfortunately there is no way here to check WHICH cells are actually returned




    }
}