package dhbw.fowlerRefactoring.main;

public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private String title;
    private int priceCode;
    public Movie(String newtitle, int newpriceCode) {
        title = newtitle;
        priceCode = newpriceCode;
    }
    public int getPriceCode() {
        return priceCode;
    }
    public void setPriceCode(int arg) {
        priceCode = arg;
    }
    public String getTitle (){
        return title;
    };

    double getCharge( int daysRented ) {
        double price = 0;
        switch ( getPriceCode()) {
            case REGULAR:
                price += 2;
                if ( daysRented > 2)
                    price += (daysRented - 2) * 1.5;
                break;
            case NEW_RELEASE:
                price += daysRented * 3;
                break;
            case CHILDRENS:
                price += 1.5;
                if ( daysRented > 3)
                    price += (daysRented - 3) * 1.5;
                break;
        }
        return price;
    }

    int getFrequentRenterPoints( int daysRented ) {
        if ((getPriceCode() == NEW_RELEASE) && daysRented > 1)
            return 2;
        else
            return 1;
    }
}