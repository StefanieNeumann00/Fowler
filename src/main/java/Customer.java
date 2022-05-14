
import java.lang.*;
import java.util.*;

class Customer
{
    private final String name;
    private final List<Rental> rentals;

    public Customer (String name)
    {
        rentals = new ArrayList<>();
        this.name = name;
    }

    public void addRental(Rental arg)
    {
        rentals.add(arg);
    }

    public String getName ()
    {
        return name;
    }

    public String statement()
    {
        StringBuilder result = new StringBuilder();
        result.append("Rental Record for ");
        result.append(this.getName());
        result.append("\n");
        result.append("\tTitle\t\tDays\tAmount\n");

        for (Rental rental: rentals)
        {
            result.append("\t");
            result.append(rental.getMovie().getTitle());
            result.append("\t\t");
            result.append(rental.getDaysRented());
            result.append("\t");
            result.append(rental.getAmount());
            result.append("\n");
        }

        result.append("Amount owed is ");
        result.append(calculateAmount());
        result.append("\n");
        result.append("You earned ");
        result.append(calculateFrequentRenterPoints());
        result.append(" frequent renter points");
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
            double thisAmount = rental.getAmount();
            totalAmount += thisAmount;
        }

        return totalAmount;
    }

}
    