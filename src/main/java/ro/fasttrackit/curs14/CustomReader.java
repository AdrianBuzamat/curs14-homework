package ro.fasttrackit.curs14;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomReader {
    private FileReader file;

    public CustomReader(String filePath) {
        try {
            this.file = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Quote> getQuotes() {
        BufferedReader myReader;
        List<Quote> result = new ArrayList<>();
        try {
            myReader = new BufferedReader(file);
            String line;
            int count = 1;
            while ((line = myReader.readLine()) != null) {
                result.add(readQuote(count++, line));
            }
        } catch (IOException e) {
            System.out.println("File not found");
        }
        return result;
    }

    private Quote readQuote(int id, String line) {
        String[] quoteData = line.split("~");
        String author = quoteData[0];
        String quote = " - " + "'" + quoteData[1] + "'";

        return new Quote(id, author, quote);
    }


}
