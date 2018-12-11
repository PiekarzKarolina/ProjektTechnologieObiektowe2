package functionality;

import model.Cell;
import model.Color;
import model.DoubleBoard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardInitializerTest {

    @Test
    void initializeBoard() {
        //given
        Boolean isGood = true;
        String boardName = "easy_board1";
        BoardInitializer initializer = new BoardInitializer();
        Cell[][] startingCells = new Cell[5][5];
        Cell[][] finalCells = new Cell[5][5];
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                switch (row) {
                    case 0:
                        switch (col) {
                            case 1:
                                startingCells[row][col] = new Cell("4");
                                break;
                            case 4:
                                startingCells[row][col] = new Cell("1");
                                break;
                            default:
                                startingCells[row][col] = new Cell(Color.WHITE);
                        }
                        break;
                    case 1:
                        if (col == 3) startingCells[row][col] = new Cell("4");
                        else startingCells[row][col] = new Cell(Color.WHITE);
                        break;
                    case 3:
                        if (col == 0) startingCells[row][col] = new Cell("2");
                        else startingCells[row][col] = new Cell(Color.WHITE);
                        break;
                    default:
                        startingCells[row][col] = new Cell(Color.WHITE);
                }
            }
        }
        for (int row = 0; row < 5; row++) {
            for (int col = 0; col < 5; col++) {
                switch (row) {
                    case 0:
                        switch (col) {
                            case 1:
                                finalCells[row][col] = new Cell("4");
                                break;
                            case 2:     //empty for purpose to make switch fall through
                            case 3:
                                finalCells[row][col] = new Cell(Color.BLACK);
                                break;
                            case 4:
                                finalCells[row][col] = new Cell("1");
                                break;
                            default:
                                finalCells[row][col] = new Cell(Color.WHITE);
                        }
                        break;
                    case 1:
                        switch (col){
                            case 3:
                                finalCells[row][col] = new Cell("4");
                                break;
                            case 2:     //empty for purpose to make switch fall through
                            case 4:
                                finalCells[row][col] = new Cell(Color.BLACK);
                                break;
                            default:
                                finalCells[row][col] = new Cell(Color.WHITE);
                                break;
                        }
                        break;
                    case 2:
                        switch (col){
                            case 3:
                                finalCells[row][col] = new Cell(Color.WHITE);
                                break;
                            default:
                                finalCells[row][col] = new Cell(Color.BLACK);

                        }
                        break;
                    case 3:
                        switch (col){
                            case 0:
                                finalCells[row][col] = new Cell("2");
                                break;
                            case 1:
                            case 4:
                                finalCells[row][col] = new Cell(Color.BLACK);
                                break;
                            default:
                                finalCells[row][col] = new Cell(Color.WHITE);
                        }
                        break;
                    case 4:
                        if(col == 0)
                            finalCells[row][col] = new Cell(Color.WHITE);
                        else
                            finalCells[row][col] = new Cell(Color.BLACK);

                }
            }
        }

        //when
        DoubleBoard doubleBoard = initializer.initializeBoard(boardName);

        //then
        assertEquals(doubleBoard.getUserBoard().getWidth(), 5);
        assertEquals(doubleBoard.getUserBoard().getHeight(), 5);
        assertEquals(doubleBoard.getFinalBoard().getWidth(), 5);
        assertEquals(doubleBoard.getFinalBoard().getHeight(), 5);


        for (int row = 0; row<5; row++){
            assertArrayEquals(startingCells[row],doubleBoard.getUserBoard().getCells()[row]);
            assertArrayEquals(finalCells[row],doubleBoard.getFinalBoard().getCells()[row]);
        }

    }
}