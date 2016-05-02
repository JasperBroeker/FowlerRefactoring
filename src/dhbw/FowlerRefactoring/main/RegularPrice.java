package dhbw.fowlerRefactoring.main;

/**
 * Created by Jasper on 02.05.2016.
 */
public class RegularPrice extends Price {

    @Override
    public int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getCharge( int daysRented ) {
        double result = 2;
        if ( daysRented > 2 )
            result += (daysRented - 2) * 1.5;
        return result;
    }
}
