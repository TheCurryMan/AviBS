import java.util.ArrayList;

public class Human extends Player
{
    
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
