
import java.lang.*;
import java.util.*;

class Customer
{
    private String name;
    private List<Rental> rentals;

    public Customer (String newname)
    {
        rentals = new ArrayList<>();
        name = newname;
    };

    public void addRental(Rental arg)
    {
        rentals.add(arg);
    };

    public String getName ()
    {
        return name;
    };

    public String statement()
    {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental: rentals)
        {
            double thisAmount = 0;
            //determine amounts for each line
            thisAmount = rental.getAmount();
            // add frequent renter points
            frequentRenterPoints += rental.getFrequentRenterPoints();
            //show figures for this rental
            result.append("\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + thisAmount + "\n");
            totalAmount += thisAmount;
        }
        //add footer lines
        result.append("Amount owed is " + totalAmount + "\n");
        result.append("You earned " + frequentRenterPoints + " frequent renter points");
        return result.toString();
    }

}
    