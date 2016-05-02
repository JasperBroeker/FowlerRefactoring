package dhbw.fowlerRefactoring.tests;

import dhbw.fowlerRefactoring.main.Customer;
import dhbw.fowlerRefactoring.main.Movie;
import dhbw.fowlerRefactoring.main.Rental;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jasper on 02.05.2016.
 */
public class MovieStoreTest {

    @Test
    public void rentTwoMovies () throws Exception {
        String ref = "dhbw.fowlerRefactoring.main.Rental Record for Sonny\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";

        Movie movie1 = new Movie( "movie1", 1 );
        Movie movie2 = new Movie( "movie2", 2 );
        Rental rentalMovie1 = new Rental( movie1, 10 );
        Rental rentalMovie2 = new Rental( movie2, 5 );

        Customer sonny = generateCustomer( "Sonny" );

        sonny.addRental( rentalMovie1 );
        sonny.addRental( rentalMovie2 );

        String sonnyStatement = sonny.statement();

        Assert.assertEquals( ref, sonnyStatement );
    }

    @Test
    public void testRentNoMovie () {
        String ref = "dhbw.fowlerRefactoring.main.Rental Record for Sonny\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "Amount owed is 0.0\n" +
                "You earned 0 frequent renter points";

        Customer sonny = generateCustomer( "Sonny" );

        String sonnyStatement = sonny.statement();

        Assert.assertEquals( ref, sonnyStatement );
    }

    private Customer generateCustomer (String name) {
        Customer customer = new Customer( name );
        return customer;
    }
}
