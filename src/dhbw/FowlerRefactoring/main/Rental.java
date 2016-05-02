package dhbw.fowlerRefactoring.main;

public class Rental {
    private Movie movie;
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

    double getCharge() {
        double price = 0;
        switch ( getMovie().getPriceCode()) {
            case Movie.REGULAR:
                price += 2;
                if ( getDaysRented() > 2)
                    price += (getDaysRented() - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                price += getDaysRented() * 3;
                break;
            case Movie.CHILDRENS:
                price += 1.5;
                if ( getDaysRented() > 3)
                    price += (getDaysRented() - 3) * 1.5;
                break;
        }
        return price;
    }
}