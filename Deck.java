import java.util.ArrayList;


public class Deck
{
    ArrayList<Card> deck = new ArrayList<Card>();


    public Deck()
    {
        for ( int i = 1; i < 14; i++ )
        {
            for (int j = 0; j < 4; j++)
            { 
                deck.add( new Card(i) );
            }
        }
    }


    public void shuffle()
    {
        ArrayList<Card> temp = new ArrayList<Card>();
        for (int i = 52; i > 0; i--)
        {
            int index = (int) Math.random()*i;
            temp.add( deck.get( index ));
            deck.remove( index );
        }
        deck = temp;
    }
}