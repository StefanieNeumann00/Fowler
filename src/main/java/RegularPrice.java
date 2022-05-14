public class RegularPrice extends Price
{
    public int getPriceCode()
    {
        return Movie.REGULAR;
    }

    public double getAmount(int daysRented)
    {
        if (daysRented > 2)
        {
            return 2 + (daysRented - 2) * 1.5;
        }
        return 2;
    }
}
