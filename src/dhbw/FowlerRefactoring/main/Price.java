package dhbw.fowlerRefactoring.main;

/**
 * Created by Jasper on 02.05.2016.
 */
public abstract class Price {
    abstract int getPriceCode ();

    abstract double getCharge( int daysRented );

    int getFrequentRenterPoints( int daysRented ) {
        return 1;
    }
}
