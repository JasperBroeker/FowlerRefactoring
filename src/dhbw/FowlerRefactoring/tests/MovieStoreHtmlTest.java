package dhbw.fowlerRefactoring.tests;

import dhbw.fowlerRefactoring.main.Customer;
import dhbw.fowlerRefactoring.main.Movie;
import dhbw.fowlerRefactoring.main.Rental;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jasper on 02.05.2016.
 */
public class MovieStoreHtmlTest {

    @Test
    public void rentTwoMovies () throws Exception {
        String ref = "<H1>Rentals for <EM>Sonny</EM></H1><P>\n" +
                "movie1: 30.0<BR>\n" +
                "movie2: 4.5<BR>\n" +
                "<P>You owe <EM>34.5</EM><P>\n" +
                "On this rental you earned <EM>3</EM> frequent rentar points <P>";

        Movie movie1 = new Movie( "movie1", 1 );
        Movie movie2 = new Movie( "movie2", 2 );
        Rental rentalMovie1 = new Rental( movie1, 10 );
        Rental rentalMovie2 = new Rental( movie2, 5 );

        Customer sonny = generateCustomer( "Sonny" );

        sonny.addRental( rentalMovie1 );
        sonny.addRental( rentalMovie2 );

        String sonnyStatement = sonny.htmlStatement();

        Assert.assertEquals( ref, sonnyStatement );
    }

    @Test
    public void testRentNoMovieHtml () {
        String ref = "<H1>Rentals for <EM>Sonny</EM></H1><P>\n" +
                "<P>You owe <EM>0.0</EM><P>\n" +
                "On this rental you earned <EM>0</EM> frequent rentar points <P>";

        Customer sonny = generateCustomer( "Sonny" );

        String sonnyStatement = sonny.htmlStatement();

        Assert.assertEquals( ref, sonnyStatement );
    }

    private Customer generateCustomer (String name) {
        Customer customer = new Customer( name );
        return customer;
    }
}
