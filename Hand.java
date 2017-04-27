import java.util.ArrayList;

public class Hand
{
    ArrayList<Card> hand = new ArrayList<Card>();
    public Hand()
    {
        
    }
    
    public void addCard(Card c)
    {
        hand.add( c );
    }
    
    public ArrayList<Card> getHand() 
    {
        return hand;
    }
    
    public String viewHand()
    {
        String finalStr = "";
        for (Card c: hand)
        {
            
        } 
        return "";
    }
 

}
