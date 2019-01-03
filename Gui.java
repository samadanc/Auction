import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Set;
import java.util.Arrays;
import java.util.HashSet;

/**
 * Write a description of class Gui here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Gui
{
    // instance variables - replace the example below with your own
    private JFrame frame;
    private Container contentPane;
    private Auction auction;
    private Set <Item> items;
    private Item[] itemsArray;
    /**
     * Constructor for objects of class Gui
     */
    public Gui()
    {
        initializer();
        makeFrame();
    }

    private void initializer(){
        auction = new Auction();
        frame = new JFrame("Auction");
        contentPane = frame.getContentPane();
        items = new HashSet();
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void makeFrame()
    {
        makeMenuBar();
        makeContent(frame);
        
        frame.pack();
        frame.setVisible(true);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private void makeMenuBar()
    {
        JMenuBar menubar = new JMenuBar();
        frame.setJMenuBar(menubar);
        
        JMenu helpMenu = new JMenu("Help");
        menubar.add(helpMenu);
        
        JMenuItem aboutItem = new JMenuItem("About");
        helpMenu.add(aboutItem);
        
        aboutItem.addActionListener(information -> info());
        
    }
    
    private void info(){
        JOptionPane.showMessageDialog(frame, "Go to our website for more information: \n www.auction.com"
        ,"About",JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void makeContent(JFrame fr){
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        //p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
        
        JButton placeItem = new JButton("Place Item");
        JButton placeBid = new JButton("Place Bid");
        JButton endAuction = new JButton("End Auction");
        
        p1.add(placeItem);
        p1.add(placeBid);
        p2.add(endAuction);
        
        contentPane.add(p1, BorderLayout.CENTER);
        contentPane.add(p2, BorderLayout.SOUTH);
        
        placeItem.addActionListener(e -> createItemPage());
        placeBid.addActionListener(e -> listItemsPage());
        endAuction.addActionListener(e -> noItemsCheck());
        /*if (!noItemsCheck()){
            endAuction.addActionListener(e -> endAuctionPage(frame));
        }*/
    }
    
    private void createItemPage(){
        frame = new JFrame("Item Page");
        contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3,2));
        makeMenuBar();
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        
        JLabel itemName = new JLabel("Enter name of item: ");
        JTextField nameField = new JTextField(10);
        JLabel itemBid = new JLabel("Enter the starting bid: ");
        JTextField bidField = new JTextField(10);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> createItem(nameField.getText(), bidField.getText(),frame));
        
        p1.add(itemName);
        p2.add(nameField);
        p3.add(itemBid);
        p4.add(bidField);
        p6.add(submit);
        
        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p6);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void createItem(String name, String bid, JFrame frame)
    {
        double amount = Double.parseDouble(bid);
        Item item1 = new Item(name, amount);
        
        auction.addItem(item1);
        
        JOptionPane.showMessageDialog(frame, "The item "+item1.getName()+" has been added."
        ,"Item Added",JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }
    
    private void listItemsPage(){
        items = auction.getItems();
        itemsArray = Arrays.copyOf(items.toArray(),items.size(),Item[].class);
        frame = new JFrame("Choose Bid Item");
        contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(items.size(),1));
        makeMenuBar();
        
        JPanel[] panels = new JPanel[items.size()];
        JButton[] buttons = new JButton[items.size()];
        JLabel[] labels = new JLabel[items.size()];
        
        for(int i = 0; i<items.size(); i++){
            panels[i] = new JPanel();
        }
        
        for(int i = 0; i<items.size(); i++){
            buttons[i] = new JButton(itemsArray[i].getName());
            panels[i].add(buttons[i]);
            
            if(itemsArray[i].highestBid() == 0.0)
            {
                labels[i] = new JLabel("Starting Bid: "+ itemsArray[i].getStartingBid());
            }
            else
            {
                labels[i] = new JLabel("Highest Bid: "+ itemsArray[i].highestBid());
            }
            
            panels[i].add(labels[i]);
        }
        
        for(JPanel panel: panels){
            contentPane.add(panel);
        }
        
        for(int i = 0; i<items.size(); i++){
            Item it = itemsArray[i];
            buttons[i].addActionListener(e -> createBidPage(it,frame));
        }
        frame.pack();
        frame.setVisible(true);
    }
    
    private void createBidPage(Item item, JFrame fr){
        fr.dispose();
        frame = new JFrame("Bidding Page");
        contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(3,2));
        makeMenuBar();
        
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();
        JPanel p6 = new JPanel();
        
        JLabel name = new JLabel("Enter your name: ");
        JTextField nameField = new JTextField(10);
        JLabel bidAmount = new JLabel("Enter your bid: ");
        JTextField amountField = new JTextField(10);
        JButton submit = new JButton("Submit");
        submit.addActionListener(e -> createBid(item, nameField.getText(), amountField.getText(),frame));
        
        p1.add(name);
        p2.add(nameField);
        p3.add(bidAmount);
        p4.add(amountField);
        p6.add(submit);
        
        contentPane.add(p1);
        contentPane.add(p2);
        contentPane.add(p3);
        contentPane.add(p4);
        contentPane.add(p5);
        contentPane.add(p6);
        
        frame.pack();
        frame.setVisible(true);
        
    }
    
    private void createBid(Item item, String name, String money, JFrame frame){
        double amount = Double.parseDouble(money);
        Bid bid1 = new Bid(name, amount);
        item.addBid(bid1);
        
        JOptionPane.showMessageDialog(frame, bid1.getName()+" added a bid of value "+bid1.getAmount()+" ."
        ,"Bid Added",JOptionPane.INFORMATION_MESSAGE);
        frame.dispose();
    }
    
    private void noItemsCheck(){
        if(items.size() == 0){
            JOptionPane.showMessageDialog(frame, "Please enter items into the auction first.","Auction has no items",JOptionPane.INFORMATION_MESSAGE);
            //return true;
        }
        else{
            endAuctionPage(frame);
        }
    }
    
    private void endAuctionPage(JFrame fr){  
        fr.dispose();
        frame = new JFrame("Choose Bid Item");
        contentPane = frame.getContentPane();
        contentPane.setLayout(new GridLayout(items.size(),1));
        makeMenuBar();
        
        JPanel[] panels = new JPanel[items.size()];
        JLabel[] itemLabels = new JLabel[items.size()];
        JLabel[] descriptionLabels = new JLabel[items.size()];
        
        for(int i = 0; i<items.size(); i++){
            panels[i] = new JPanel();
        }
        
        for(int i = 0; i<items.size(); i++){
            itemLabels[i] = new JLabel(itemsArray[i].getName()+": ");
            descriptionLabels[i] = new JLabel(itemsArray[i].highestBidder() + " won with a bid of $" 
            +itemsArray[i].highestBid()+".");
        }
        
        for(int i = 0; i<items.size(); i++){
            panels[i].add(itemLabels[i]);
            panels[i].add(descriptionLabels[i]);
        }
        
        for(JPanel panel: panels){
            contentPane.add(panel);
        }
        frame.pack();
        frame.setVisible(true);
    }
}
