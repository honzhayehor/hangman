package logic.suppliers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVWordSupplier implements WordSupplier {
    private String CSV_PATH = "src/main/resources/words.csv";

    @Override
    public String supplyWords() {
        List<String> wordList = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Path.of(CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                wordList.add(line.split(",")[0]);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return WordSupplier.getRandomElement(wordList);
    }

    public void setCSV_PATH(String csvPath) {
        CSV_PATH = csvPath;
    }
}
