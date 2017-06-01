import java.util.ArrayList;


/**
 * 
 * Represents a deck in the AviBS project
 *
 * @author Susan
 */
public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();


    /**
     * Constructs a new deck with 52 cards. There are four of each number from
     * 1-13, and the 52 cards in the deck are randomly shuffled.
     * 
     * @author Susan
     */
    public Deck()
    {
        for ( int i = 1; i < 14; i++ )
        {
            for ( int j = 0; j < 4; j++ )
            {
                deck.add( new Card( i ) );
            }
        }

        this.shuffle();

    }


    /**
     * Randomly shuffles the cards in the deck
     * 
     * @author Susan
     */
    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        for ( int i = 52; i > 0; i-- )
        {
            int index = (int)( Math.random() * i );
            temp.add( deck.get( index ) );
            deck.remove( index );
        }
        deck = temp;
    }


    /**
     * Gets the list of the cards in the deck
     * 
     * @return the cards in deck
     * @author Susan
     */
    public ArrayList<Card> getDeck()
    {
        return deck;
    }

}