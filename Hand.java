import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Hand extends ArrayList<Integer>
{
    ArrayList<Card> hand = new ArrayList<Card>();
    public Hand()
    {
        
    }
    
    public void removeNum(int cint)
    {
        for (Card c:hand)
        {
            if (c.getNum() == cint)
            {
                hand.remove( c );
                break;
            }
        }
    }
    
    public void addCard(Card c)
    {
        hand.add( c );
        Comparator<Card> comp = new CardComparator();
        Collections.sort(hand, comp);
    }
    
    public void addCards(ArrayList<Card> c)
    {
        hand.addAll( c );
        Comparator<Card> comp = new CardComparator();
        Collections.sort(hand, comp);
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
            finalStr += " " + c.getNum();
        } 
        return finalStr;
    }
    
    public boolean contains(String input)
    {
        return viewHand().indexOf( input) >=0;
    }
}
