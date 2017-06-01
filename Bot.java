import java.util.ArrayList;


/**
 * 
 * Represents an AI player in the AviBS project
 *
 * @author Avi
 * @author Period: 5
 * @author Assignment: AviBS
 * @author Sources: None
 */
public class Bot extends Player
{
    private ArrayList<Integer> singles = new ArrayList<Integer>();

    private ArrayList<Integer> doubles = new ArrayList<Integer>();

    private ArrayList<Integer> triples = new ArrayList<Integer>();

    private ArrayList<Integer> quadruples = new ArrayList<Integer>();


    /**
     * Constructs a new bot with a given name
     * 
     * @param name
     *            the bot's name
     * @author Avi
     */
    public Bot( String name )
    {
        super( name, false );
    }


    /**
     * Sorts the cards in the hand into singles, doubles, triples and quadruples
     * 
     * @author Avi
     */
    public void sortCards()
    {
        singles.clear();
        doubles.clear();
        triples.clear();
        quadruples.clear();
        for ( int i = 1; i <= 13; i++ )
        {
            int counter = 0;
            for ( Card c : this.getHand() )
            {
                if ( i == c.getNum() )
                {
                    counter++;
                }
            }
            switch ( counter )
            {
                case 1:
                    singles.add( i );
                    break;
                case 2:
                    doubles.add( i );
                    break;
                case 3:
                    triples.add( i );
                    break;
                case 4:
                    quadruples.add( i );
                    break;
                default:
                    counter = 0;
                    break;
            }
        }

    }


    /**
     * If there is a current card being played, this is the AI methods that
     * determines what the Bot should play, bluff or skip
     * 
     * @param currentCard
     *            the type of the current pile
     * @param p
     *            the current pile
     * @return the cards to play
     * @author Avi
     */
    public ArrayList<Card> BotPlayCurrentCard( int currentCard, Pile p )
    {

        ArrayList<Card> play = new ArrayList<Card>();
        ArrayList<Card> hand = super.getHand();
        for ( Card c : hand )
        {
            if ( c.getNum() == currentCard )
            {
                play.add( new Card( currentCard ) );

            }
        }

        if ( play.size() > 3 || ( play.size() == 3
            & ( p.getNumOfCards() > 1 & Math.random() > 0.4 ) ) )
        {
            play.clear();
            play.add( new Card( 14 ) );
            return play;
        }

        for ( int i = 0; i < play.size(); i++ )
        {
            this.removeCard( currentCard );
        }

        if ( play.size() < 1 )
        {
            if ( p.getNumOfCards() > 6 )
            {
                return play;
            }
            else if ( Math.random() > 0.4 )
            {
                if ( singles.size() > 0 )
                {
                    play.add( new Card( singles.get( 0 ) ) );
                    this.removeCard( singles.get( 0 ) );

                    if ( Math.random() > 0.8 && singles.size() > 0 )
                    {
                        play.add( new Card( singles.get( 0 ) ) );
                        this.removeCard( singles.get( 0 ) );
                    }
                }
                else if ( doubles.size() > 0 )
                {
                    play.add( new Card( doubles.get( 0 ) ) );
                    this.removeCard( doubles.get( 0 ) );

                }

            }
        }

        return play;

    }


    /**
     * Returns what cards to play if the Bot is the first to go
     * 
     * @return The cards to play
     * @author Avi
     */
    public ArrayList<Card> BotPlayHighest()
    {

        this.sortCards();
        ArrayList<Card> play = new ArrayList<Card>();
        if ( this.getHand().size() == 1 )
        {
            play.add( this.getHand().get( 0 ) );
            play.add( this.getHand().get( 0 ) );

            return play;
        }

        if ( quadruples.size() > 0 )
        {

            for ( int i = 0; i < 5; i++ )
            {
                play.add( new Card( quadruples.get( 0 ) ) );
                this.removeCard( quadruples.get( 0 ) );
            }

        }
        else if ( triples.size() > 0 )
        {

            if ( Math.random() > 0.4 )
            {
                if ( singles.size() > 0 )
                {
                    play.add( new Card( triples.get( 0 ) ) );
                    play.add( new Card( singles.get( 0 ) ) );
                    this.removeCard( singles.get( 0 ) );
                }
                else
                {
                    for ( int i = 0; i < 4; i++ )
                    {

                        play.add( new Card( triples.get( 0 ) ) );
                        this.removeCard( triples.get( 0 ) );
                    }
                }
            }
            else
            {
                for ( int i = 0; i < 4; i++ )
                {

                    play.add( new Card( triples.get( 0 ) ) );
                    this.removeCard( triples.get( 0 ) );
                }
            }

        }
        else if ( doubles.size() > 0 )
        {

            if ( Math.random() > 0.3 )
            {
                if ( singles.size() > 0 )
                {
                    play.add( new Card( doubles.get( 0 ) ) );
                    play.add( new Card( singles.get( 0 ) ) );
                    this.removeCard( singles.get( 0 ) );
                }
                else
                {
                    for ( int i = 0; i < 3; i++ )
                    {

                        play.add( new Card( doubles.get( 0 ) ) );
                        this.removeCard( doubles.get( 0 ) );
                    }
                }
            }
            else
            {
                for ( int i = 0; i < 3; i++ )
                {

                    play.add( new Card( doubles.get( 0 ) ) );
                    this.removeCard( doubles.get( 0 ) );
                }
            }
        }
        else if ( singles.size() > 0 )
        {

            if ( Math.random() > 0.3 )
            {
                if ( singles.size() > 1 )
                {
                    play.add( new Card( singles.get( 0 ) ) );
                    play.add( new Card( singles.get( 1 ) ) );
                    this.removeCard( singles.get( 1 ) );
                }

                else
                {
                    play.add( new Card( singles.get( 0 ) ) );
                    this.removeCard( singles.get( 0 ) );
                }
            }
            else
            {
                play.add( new Card( singles.get( 0 ) ) );
                this.removeCard( singles.get( 0 ) );

            }
        }
        return play;
    }

}
