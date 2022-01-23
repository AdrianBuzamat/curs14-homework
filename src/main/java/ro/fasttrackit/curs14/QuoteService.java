package ro.fasttrackit.curs14;

import java.util.*;

public class QuoteService {
    private final List<Quote> quotes = new ArrayList<>();

    public QuoteService(List<Quote> quotes) {
        if (quotes != null) {
            this.quotes.addAll(quotes);
        }
    }

    public List<String> getAllQuotes() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getId() + " " + quote.getAuthor() + " " + quote.getQuote() + "");
        }
        return result;
    }

    public List<String> getQuotesForAuthor(String author) {
        List<String> result = new ArrayList<>();
        if (author!=null){
            for (Quote quote : quotes) {
                if (author.equalsIgnoreCase(quote.getAuthor())) {
                    result.add(quote.getQuote());
                }
            }
        }
        return result;
    }

    public List<String> getAuthors() {
        List<String> result = new ArrayList<>();
        for (Quote quote : quotes) {
            result.add(quote.getAuthor());
        }
        return result;
    }

    public void setFavourite(int id, boolean favourite) { //validate id
        for (Quote quote : quotes) {
            if (quote.getId() == id) {
                quote.setFavourite(favourite);
            }
        }
    }

    public List<Quote> getFavourites() {
        List<Quote> result = new ArrayList<>();
        for (Quote quote : quotes) {
            if (quote.getFavourite()) {
                result.add(quote);
            }
        }
        return result;
    }

    public String getRandomQuote() {
        String result = null;
        Random randomGenerator = new Random();
        int randomNr = randomGenerator.nextInt(quotes.size() - 1) + 1;
        for (Quote quote : quotes) {
            if (randomNr == quote.getId()) {
                result = quote.getId() + quote.getAuthor() + quote.getQuote();
            }
        }
        return result;
    }
}
