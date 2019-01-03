import java.util.Set;
import java.util.Arrays;

/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    // instance variables - replace the example below with your own
    private Auction auction;
    private Item item1;
    private Item item2;
    private Item item3;
    private Bid b1;
    private Bid b2;
    private Bid b3;
    private Bid b4;
    private Bid b5;
    private Bid b6;
    
    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        
        item1 = new Item("Bag",10.5);
        item2 = new Item("Pen",2);
        item3 = new Item("Phone", 100.9);
        b1 = new Bid("Samad", item1, 14);
        b2 = new Bid("Fume", item1, 14);
        b3 = new Bid("Rahul", item1, 10);
        b4 = new Bid("Mohan", item2, 9);
        b5 = new Bid("Gandhi", item2, 5);
        b6 = new Bid("Trump", item2, 20);
        auction = new Auction();
        auction.addItem(item1);
        auction.addItem(item2);
        auction.addItem(item3);
    }
    
    public String testAddBid(){ 
        return item1.addBid(b3);
    }
    
    public String testShowBids(){
        return item1.showBids();
    }
    
    public double testHighestBids(){
        return item1.highestBid();
    }
    
    public void testSomething(){
        Set <Item> items = auction.getItems();
        Item[] itemsArray = Arrays.copyOf(items.toArray(),items.size(),Item[].class);
        for(Item i: itemsArray){
            System.out.println(i.getName());
        }
    }
    
    public void fiveMultiples(){
        int x = 11;
        while(x>10 && x<95){
            if (x%5==0){
                System.out.println(x);
                x++;
            }
        }
    }
}
