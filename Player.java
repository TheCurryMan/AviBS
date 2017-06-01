import java.util.ArrayList;
/**
 * Represents a player in the AviBS project
 *
 *  @author  Avi, Susan
 */
public abstract class Player
{
    private String name;

    private Hand currentHand;

    private boolean isHuman;

    /**
     * No-arg constructor for a new player
     * @author Avi
     */
    public Player()
    {

    }

    /**
     * Constructs a new player with a given name that is either a Bot or a Human. Also 
     * initializes the player's current hand
     * @param name the player's name
     * @param type whether it's a human or a bot
     * @author Avi
     */
    public Player( String name, boolean type )
    {
        this.name = name;
        this.currentHand = new Hand();
        this.isHuman = type;
    }

    /**
     * Adds a card to the player's hand
     * @param c card to be added
     * @author Avi
     */
    public void addCard( Card c )
    {
        this.currentHand.addCard( c );
    }

    /**
     * Prints the cards that are currently in the player's hand
     * @return a string with the cards that are currently in the player's hand
     * @author Avi
     */
    public String viewHand()
    {
        return currentHand.viewHand();
    }

    /**
     * Gets the current player's hand
     * @return the player's hand
     * @author Avi
     */
    public ArrayList<Card> getHand()
    {
        return this.currentHand.getHand();
    }

    /**
     * Gets the current player's name
     * @return the player's name
     * @author Avi
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Adds the cards to the player's hand
     * @param cards cards to be added
     * @author Susan
     */
    public void addCards( ArrayList<Card> cards )
    {
        this.currentHand.addCards( cards );
    }

    /**
     * Removes a card from the player's hand
     * @param c card to be removed
     * @author Susan
     */
    public void removeCard( int c )
    {
        this.currentHand.removeNum( c );
    }

    /**
     * Checks whether the player is a bot or a human
     * @return true if the player is a bot, false otherwise
     * @author Susan
     */
    public boolean isBot()
    {
        return !isHuman;
    }

    public abstract void sortCards();


    public abstract ArrayList<Card> BotPlayCurrentCard( int c, Pile p );
    


    public abstract ArrayList<Card> BotPlayHighest();
}
