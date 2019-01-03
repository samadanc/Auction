import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
/**
 * Write a description of class Auction here.
 *
 * @author (Samad alias Nyein Chan)
 * @version (23rd November 2018)
 */
public class Auction
{
    // instance variables - replace the example below with your own
    private HashMap<Item,ArrayList<Bid>> itemBids;
    
    /**
     * Constructor for objects of class Auction
     */
    public Auction()
    {
        itemBids = new HashMap<>();
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String addItem(Item item)
    {
        itemBids.put(item,item.getBids());
        return (item.getName() + " is added to the auction.");
    }
    
    public String updateBids(Item item)
    {
        itemBids.replace(item, item.getBids());
        return "Bids have been updated";
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String removeItem(Item item)
    {
        itemBids.remove(item);
        return (item.getName() + " has been removed from the auction.");
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String showItems()
    {
        Set<Item> items = itemBids.keySet();
        return
        items.stream()
            .map(item -> item.getName())
            .reduce("", (names,name)->names+" "+name);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public Set<Item> getItems()
    {
        Set<Item> items = itemBids.keySet();
        return items;
    }
    
}
