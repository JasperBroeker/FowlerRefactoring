package dhbw.fowlerRefactoring.main;

public class Rental {
    Movie movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return movie;
    }

    int getFrequentRenterPoints () {
        return movie.price.getFrequentRenterPoints( getDaysRented() );
    }

    double calculateCharge () {
        return movie.price.getCharge( daysRented );
    }
}