import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Represents a hand in the SafeTrade project
 * 
 * @author Susan, Harsh
 */
public class Hand extends ArrayList<Integer>
{
    ArrayList<Card> hand = new ArrayList<Card>();


    /**
     * Constructs a new hand
     * 
     * @author Harsh
     */
    public Hand()
    {

    }


    /**
     * Removes a number from the hand
     * 
     * @param cint
     *            the number to be removed
     * @author Susan
     */
    public void removeNum( int cint )
    {
        for ( Card c : hand )
        {
            if ( c.getNum() == cint )
            {
                hand.remove( c );
                break;
            }
        }
    }


    /**
     * Adds a card to the hand
     * 
     * @param c
     *            card to be added
     * @author Harsh
     */
    public void addCard( Card c )
    {
        hand.add( c );
        Comparator<Card> comp = new CardComparator();
        Collections.sort( hand, comp );
    }


    /**
     * Adds multiple cards to the hadn
     * 
     * @param c
     *            cards to be added
     * @author Harsh
     */
    public void addCards( ArrayList<Card> c )
    {
        hand.addAll( c );
        Comparator<Card> comp = new CardComparator();
        Collections.sort( hand, comp );
    }


    /**
     * Gets the player's hand
     * 
     * @return the hand
     * @author Susan
     */
    public ArrayList<Card> getHand()
    {
        return hand;
    }


    /**
     * Prints out the player's hand in a string
     * 
     * @return the String with all of the player's cards
     * @author Susan
     */
    public String viewHand()
    {
        String finalStr = "";
        for ( Card c : hand )
        {
            finalStr += " " + c.getNum();
        }
        return finalStr;
    }


    /**
     * Checks if the player's hand contains a certain card
     * 
     * @param input
     *            the card
     * @return true if the player's hand contains the card, false if not
     * @author Susan
     */
    public boolean contains( String input )
    {
        return viewHand().indexOf( input ) >= 0;
    }
}
