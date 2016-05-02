package dhbw.fowlerRefactoring.main;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();
    public Customer (String newname){
        name = newname;
    };
    public void addRental(Rental arg) {
        rentals.addElement(arg);
    };
    public String getName (){
        return name;
    };
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = rentals.elements();	    
        String result = "dhbw.fowlerRefactoring.main.Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            // add bonus for a two day new release rental
            frequentRenterPoints += each.getFrequentRenterPoints();
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
            totalAmount += each.getCharge();
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return result;
    }

    public String htmlStatement () {
        Enumeration enumRentals = rentals.elements();
        String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
        while ( enumRentals.hasMoreElements() ) {
            Rental current = (Rental) enumRentals.nextElement();
            result += current.getMovie().getTitle() + ": " + String.valueOf( current.getCharge() ) + "<BR>\n";
        }
        result += "<P>You owe <EM>" + String.valueOf( getTotalCharge() ) + "</EM><P>\n";
        result += "On this rental you earned <EM>" + String.valueOf( getTotalFrequentRenterPoints() ) + "</EM> frequent rentar points <P>";
        return result;
    }

    private double getTotalCharge () {
        double result = 0;
        Enumeration enumRentals = rentals.elements();
        while (enumRentals.hasMoreElements()) {
            Rental current = (Rental) enumRentals.nextElement();
            result += current.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints () {
        int result = 0;
        Enumeration enumRentals = rentals.elements();
        while ( enumRentals.hasMoreElements() ) {
            Rental current = (Rental) enumRentals.nextElement();
            result += current.getFrequentRenterPoints();
        }
        return result;
    }
}
    