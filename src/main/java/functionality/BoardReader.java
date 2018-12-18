package functionality;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class BoardReader {
    private final List<CSVRecord> records;

    public BoardReader(String fileName) {
        this.records = readBoard(fileName);
    }

    private List<CSVRecord> readBoard(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        List<CSVRecord> records = null;

        try {
            File file = new File(classLoader.getResource(fileName).getFile());
            file.createNewFile();
            Reader reader = new FileReader(file);

            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            records = csvParser.getRecords();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return records;
    }

    public List<CSVRecord> getRecords() {
        return records;
    }
}
