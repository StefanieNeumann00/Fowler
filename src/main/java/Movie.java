public class Movie
{
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;
    private final String title;
    private Price price;

    public Movie(String title, int priceCode)
    {
        this.title = title;
        setPriceCode(priceCode);
    }

    public void setPriceCode(int priceCode)
    {
        switch (priceCode)
        {
            case REGULAR:
                price = new RegularPrice();
                break;
            case CHILDRENS:
                price = new ChildrensPrice();
                break;
            case NEW_RELEASE:
                price = new NewReleasePrice();
                break;
            default:
                throw new IllegalArgumentException("Incorrect Price Code");
        }
    }

    public String getTitle ()
    {
        return title;
    }

    public double getAmount(int daysRented)
    {
        return price.getAmount(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented)
    {
        return price.getFrequentRenterPoints(daysRented);
    }
}