public class ChildrensPrice extends Price
{
    public int getPriceCode()
    {
        return Movie.CHILDRENS;
    }

    public double getAmount(int daysRented)
    {
        if (daysRented > 3)
        {
            return 1.5 + (daysRented - 3) * 1.5;
        }
        return 1.5;
    }
}
