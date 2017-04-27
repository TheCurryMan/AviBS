import java.util.ArrayList;


public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();


    public Deck()
    {
        for ( int i = 1; i < 14; i++ )
        {
            for ( int j = 0; j < 4; j++ )
                deck.add( new Card( i ) );
        }
    }


    public void shuffle()
    {
        
    }
}