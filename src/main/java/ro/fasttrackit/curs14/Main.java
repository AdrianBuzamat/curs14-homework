package ro.fasttrackit.curs14;

public class Main {
    public static void main(String[] args){
        CustomReader reader = new CustomReader("src\\main\\resources\\quotes.txt");
        QuoteService quotes = new QuoteService(reader.getQuotes());
        //System.out.println(quotes.getAllQuotes());
        //System.out.println(quotes.getQuotesForAuthor("Lao Tzu"));
        //System.out.println(quotes.getAuthors());
        quotes.setFavourite(123, true);
        quotes.setFavourite(33, true);
        quotes.setFavourite(534, true);
        quotes.setFavourite(888, true);
        quotes.setFavourite(3212222, true);//de tratat

        //System.out.println(quotes.getFavourites());

        System.out.println(quotes.getRandomQuote());

    }
}
