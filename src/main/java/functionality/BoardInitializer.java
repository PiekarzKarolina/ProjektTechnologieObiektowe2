package functionality;

import model.Board;
import model.DoubleBoard;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

public class BoardInitializer {

    public DoubleBoard initializeBoard(String boardName) {
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            File file = new File(classLoader.getResource(boardName).getFile());
            file.createNewFile();
            Reader reader = new FileReader(file);

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            List<CSVRecord> records = csvParser.getRecords();
            int height = records.size();
            int width = records.get(0).size();

            int i = 0;
            for (CSVRecord record : records) {
                int j = 0;

                for (String cell : record) {
                    switch (cell) {
                        case "B":
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
                i++;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

//        return new DoubleBoard(new Board(), new Board());
        return null;
    }

}
