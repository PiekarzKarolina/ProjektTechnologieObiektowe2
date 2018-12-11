package functionality;

import model.Cell;
import model.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellEqualsTest {

    @Test
    void equals() {
        //given
        Cell whiteCell = new Cell(Color.WHITE);
        Cell secondWhiteCell = new Cell(Color.WHITE);
        Cell blackCell = new Cell(Color.BLACK);
        Cell secondBlackCell = new Cell(Color.BLACK);
        Cell blueCell = new Cell(Color.BLUE);
        Cell secondBlueCell = new Cell(Color.BLUE);
        Cell pinkCell = new Cell(Color.PINK);
        Cell secondPinkCell = new Cell(Color.PINK);
        Cell greenCell = new Cell(Color.PINK);
        Cell secondGreenCell = new Cell(Color.PINK);
        Cell islandCell3 = new Cell("3");
        Cell secondIslandCell3 = new Cell("3");
        Cell islandCell4 = new Cell("4");
        Cell secondIslandCell4 = new Cell("4");

        //when

        //then
        assertEquals(whiteCell,secondWhiteCell);
        assertEquals(blackCell,secondBlackCell);
        assertEquals(blueCell,secondBlueCell);
        assertEquals(pinkCell,secondPinkCell);
        assertEquals(greenCell,secondGreenCell);

        assertEquals(islandCell3, secondIslandCell3);
        assertEquals(islandCell4, secondIslandCell4);

        assertNotEquals(islandCell3,islandCell4);

        assertNotEquals(islandCell3,whiteCell);
        assertNotEquals(islandCell3,pinkCell);

        assertNotEquals(whiteCell,blackCell);
        assertNotEquals(pinkCell,blackCell);
        assertNotEquals(greenCell,whiteCell);

    }
}