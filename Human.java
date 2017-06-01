import java.util.ArrayList;


/**
 * 
 * Human Class Creates class of an actual human who controls it
 *
 * @author Avi
 * @version May 31, 2017
 * @author Period: 5
 * @author Assignment: AviBS
 *
 */
public class Human extends Player
{
    /**
     * Creates Human
     * 
     * @param name
     * @author Avi
     */
    public Human( String name )
    {
        super( name, true );
    }


    @Override
    public void sortCards()
    {

    }


    @Override
    public ArrayList<Card> BotPlayCurrentCard( int c, Pile p )
    {
        return null;
    }


    @Override
    public ArrayList<Card> BotPlayHighest()
    {
        return null;
    }

}
