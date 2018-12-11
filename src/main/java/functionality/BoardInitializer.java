package functionality;

import model.Board;
import model.Cell;
import model.CellSet;
import model.DoubleBoard;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;

public class BoardInitializer {

    public DoubleBoard initializeBoard(String boardName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(boardName).getFile());
            file.createNewFile();
            Reader reader = new FileReader(file);

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            int height = 0;
            int width = 0;
            int i = 0;
            ArrayList<ArrayList<Cell>> finalCells;
            ArrayList<ArrayList<Cell>> startingCells;

            for (CSVRecord record : csvParser) {
                int j = 0;

                for (String cell : record) {
                    switch (cell) {
                        case "B":
                            CellSet oneCell = new CellSet();
                            System.out.println("BLACK");
                            break;
                        case "W":
                            System.out.println("WHITE");
                            break;
                        default:
                            System.out.println(cell);
                            break;
                    }

                    j++;
                }

                width = record.size();
                height++;
                i++;
            }
            System.out.println(height + " " + width);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new DoubleBoard(new Board(), new Board());
        return null;
    }

}
