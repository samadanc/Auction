import java.util.ArrayList;

/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String name;
    private double startingBid;
    private ArrayList<Bid> bids;
    
    public Item(){
    }
    
    /**
     * Constructor for objects of class Item
     */
    public Item(String name,double startingBid)
    {
        this.name = name;
        this.startingBid = startingBid;
        bids = new ArrayList<>();
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
    public ArrayList<Bid> getBids()
    {
        return bids;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double getStartingBid()
    {
        return startingBid;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void setStartingBid(double startingBid)
    {
        this.startingBid = startingBid;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String addBid(Bid bid)
    {
        if (amountCheck(bid.getAmount()))
        {
            bids.add(bid);
            return "A bid of amount " + bid.getAmount() + " was placed by " + bid.getName();
        }
        else
        {
            return "The amount is too less.";
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private boolean amountCheck(double amount)
    {
        if (amount >= this.getStartingBid())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public double highestBid()
    {
        return 
        bids.stream()
            .map(bid -> bid.getAmount())
            .reduce(0.0, (highestBid, amount) -> Double.max(highestBid,amount)); 
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String highestBidder()
    {
        for(Bid b: bids){
            if (b.getAmount() == highestBid()){
                return b.getName();
            }
        }
        return "Could Not find Name.";
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String showBids()
    {
        return
        bids.stream()
            .map(bid -> bid.getName()+": "+ bid.getAmount())
            .reduce("", (allBids, bidDescribe) -> allBids + "\n" + bidDescribe);
    }
}
