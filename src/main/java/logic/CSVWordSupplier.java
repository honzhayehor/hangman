package logic;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVWordSupplier implements WordSupplier{
    private String CSV_PATH = "src/main/resources/words.csv";

    public List<String> supplyWords(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Error: Amount of requested words cannot be negative or zero");
        }

        int counter = 0;
        List<String> wordList = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Path.of(CSV_PATH))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (counter == amount) {
                    break;
                } else {
                    wordList.add(line.split(",")[0]);
                    counter++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordList;
    }

    public void setCSV_PATH(String csvPath) {
        CSV_PATH = csvPath;
    }
}
