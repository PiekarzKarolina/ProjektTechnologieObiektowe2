package functionality;

import model.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

public class BoardInitializer {

    Cell[][] finalCells;
    Cell[][] startingCells;
    int height, width;

    public DoubleBoard initializeBoard(String boardName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(boardName).getFile());
            file.createNewFile();
            Reader reader = new FileReader(file);

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            List<CSVRecord> records = csvParser.getRecords();
            height = records.size();
            width = records.get(0).size();
            Cell[][] finalCells = new Cell[height][width];
            Cell[][] startingCells = new Cell[height][width];

            int i=0;
            for (CSVRecord record : csvParser) {
                int j = 0;
                for (String cell : record) {
                    switch (cell) {
                        case "B":
                            Cell finalBlackCell = new Cell(Color.BLACK);
                            finalCells[i][j] = finalBlackCell;
                            Cell startingBlackCell = new Cell(Color.NONE);
                            startingCells[i][j] = startingBlackCell;
                            break;
                        case "W":
                            Cell finalWhiteCell = new Cell(Color.WHITE);
                            finalCells[i][j] = finalWhiteCell;
                            Cell startingWhiteCell = new Cell(Color.NONE);
                            startingCells[i][j] = startingWhiteCell;
                            break;
                        default:
                            Cell island = new Cell(Color.NONE, cell);
                            finalCells[i][j] = island;
                            startingCells[i][j] = island;
                            break;
                    }
                    j++;
                }
                i++;
            }
            System.out.println(height + " " + width);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DoubleBoard(new Board(startingCells, height, width), new Board(finalCells, height, width));
    }

}
