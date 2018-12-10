package functionality;

import model.Board;
import model.DoubleBoard;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BoardInitializer {

    public DoubleBoard initializeBoard(String boardName){
        try {
            Reader reader = Files.newBufferedReader(Paths.get("/resources/" + boardName));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            for (CSVRecord csvRecord : csvParser) {

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }

        Board userBoard = new Board();
        Board finalBoard = new Board();
    }

}
