
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
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for " + this.getName() + "\n");
        result.append("\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n");

        for (Rental rental: rentals)
        {
            result.append("\t" + rental.getMovie().getTitle()+ "\t" + "\t" + rental.getDaysRented() + "\t" + rental.getAmount() + "\n");
        }

        result.append("Amount owed is " + calculateAmount() + "\n");
        result.append("You earned " + calculateFrequentRenterPoints() + " frequent renter points");
        return result.toString();
    }

    private int calculateFrequentRenterPoints()
    {
        int frequentRenterPoints = 0;

        for (Rental rental: rentals)
        {
            frequentRenterPoints += rental.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    private double calculateAmount()
    {
        double totalAmount = 0;

        for (Rental rental: rentals)
        {
            double thisAmount = 0;
            thisAmount = rental.getAmount();
            totalAmount += thisAmount;
        }

        return totalAmount;
    }

}
    