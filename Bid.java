
/**
 * Write a description of class Bid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bid
{
    // instance variables - replace the example below with your own
    private Item item;
    private double amount;
    private String name;

    /**
     * Constructor for objects of class Bid
     */
    public Bid(String name, double amount)
    {
        this.item = item;
        this.amount = amount;
        this.name = name;
    }
    
    public Bid(String name, Item item, double amount)
    {
        this.item = item;
        this.amount = amount;
        this.name = name;
        item.addBid(this);
    }
       
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getAmount()
    {
        return amount;
    }
       
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getItemName()
    {
        return item.getName();
    }
       
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getName()
    {
        return name;
    }
       
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String setName(String name)
    {
        this.name = name;
        return "Name of the bidder was changed to: " + name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String setAmount(double amount)
    {
        this.amount = amount;
        return "Amount was changed to: " + amount;
    }
}
