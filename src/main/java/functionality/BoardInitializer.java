package functionality;

import model.*;
import org.apache.commons.csv.CSVRecord;

import java.util.List;

public class BoardInitializer {
    public DoubleBoard initializeBoard(BoardReader reader) {
        List<CSVRecord> records = reader.getRecords();

        int height = records.size();
        int width = records.get(0).size();

        Cell[][] startingCells = new Cell[height][width];
        Cell[][] finalCells = new Cell[height][width];

        int i = 0;
        for (CSVRecord record : records) {
            int j = 0;
            for (String cell : record) {
                switch (cell) {
                    case "B":
                        finalCells[i][j] = new Cell(Color.BLACK);
                        startingCells[i][j] = new Cell(Color.SILVER);
                        break;
                    case "W":
                        finalCells[i][j] = new Cell(Color.WHITE);
                        startingCells[i][j] = new Cell(Color.SILVER);
                        break;
                    default:
                        finalCells[i][j] = new Cell(cell);
                        startingCells[i][j] = new Cell(cell);
                        break;
                }
                j++;
            }
            i++;
        }

        return new DoubleBoard(new Board(startingCells), new Board(finalCells));
    }

}
