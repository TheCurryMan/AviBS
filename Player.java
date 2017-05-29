import java.util.ArrayList;


public class Player
{
    private String name;

    private Hand currentHand;

    private boolean isHuman;


    public Player()
    {

    }


    public Player( String name, boolean type )
    {
        this.name = name;
        this.currentHand = new Hand();
        this.isHuman = type;
    }


    public void addCard( Card c )
    {
        this.currentHand.addCard( c );
    }


    public String viewHand()
    {
        return currentHand.viewHand();
    }


    public ArrayList<Card> getHand()
    {
        return this.currentHand.getHand();
    }


    public String getName()
    {
        return this.name;
    }


    public void addCards( ArrayList<Card> cards )
    {
        this.currentHand.addCards( cards );
    }


    public void removeCard( int c )
    {
        this.currentHand.removeNum( c );
    }


    public boolean isBot()
    {
        return !isHuman;
    }


    public void sortCards()
    {
    };


    public ArrayList<Card> BotPlayCurrentCard( int c, Pile p )
    {
        return null;
    }


    public ArrayList<Card> BotPlayHighest()
    {
        return null;
    }

}
