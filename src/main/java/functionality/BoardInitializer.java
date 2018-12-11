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
    private Cell[][] startingCells;
    private Cell[][] finalCells;
    private int height, width;

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
            finalCells = new Cell[height][width];
            startingCells = new Cell[height][width];

            int i = 0;
            for (CSVRecord record : records) {
                int j = 0;
                for (String cell : record) {
                    switch (cell) {
                        case "B":
                            finalCells[i][j] = new Cell(Color.BLACK);
                            startingCells[i][j] = new Cell(Color.WHITE);
                            break;
                        case "W":
                            finalCells[i][j] = new Cell(Color.WHITE);
                            startingCells[i][j] = new Cell(Color.WHITE);
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DoubleBoard(new Board(startingCells, width, height), new Board(finalCells, width, height));
    }

}
