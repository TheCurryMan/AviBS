import java.util.ArrayList;
/**
 * Represents the pile in the middle in the AviBS project
 *
 *  @author  Harsh, Susan
 */
public class Pile
{
    ArrayList<Card> currentPile;
    ArrayList<Card> lastAdd;
    int currentCard;
    
    /**
     * Constructs a new pile and initializes an ArrayList for the current pile, 
     * an ArrayList for the most recently added card(s), and an int to refer to the
     * current card's value. 
     * @author Susan
     */
    public Pile()
    {
        currentPile = new ArrayList<Card>();
        lastAdd = currentPile;
        currentCard = 0;
    }
    
    /**
     * Adds the cards that a player plays to the pile as well as the card
     * type if it's the first turn/starting off a new piile
     * @param c cards that the player plays
     * @param type number that the player plays them as (on the first turn only) 
     * @author Harsh
     */
    public void addCards(ArrayList<Card> c, int type) 
    {
        if (currentPile.size() == 0)
        {
            currentCard = type;
        }
        currentPile.addAll( c );
        lastAdd = c;
    } 
    
    /**
     * Checks to see if a bluff that's called is valid/correct. If so, the player who called the bluff
     * gets all the cards. If not, the player who played the wrong card gets the pile. 
     * @param currentPlayer the player who called the bluff
     * @param lastPlayer the last player who played a card
     * @return the player who is correct
     * @author Susan
     */
    public Player bluffCalled(Player currentPlayer, Player lastPlayer)
    {
       
        for (Card c: lastAdd)
        {
            if (c.getNum() != currentCard) 
            {
                lastPlayer.addCards( currentPile );
                currentPile.clear();
                lastAdd.clear();
                currentCard = 0;
                return currentPlayer;
            }             
        }
        currentPlayer.addCards( currentPile );
        currentPile.clear();
        lastAdd.clear();
        currentCard = 0;
        return lastPlayer;
    }
    
    /**
     * Returns a string containing all of the cards that were played on the most recent turn
     * @return the cards that were most recently played
     * @author Harsh
     */
    public String getLastAdd()
    {
        String str = "";
        for (Card c : lastAdd)
        {
            str = str + c.getNum() + " ";
        }
        return str;
    }
    
    /**
     * Returns a string containing all of the cards that are in the pile
     * @return the cards in the pile
     * @author Harsh
     */
    public String getPile()
    {
        String str = "";
        for (Card c : currentPile)
        {
            str = str + c.getNum() + " ";
        }
        return str;
    }
    
    /**
     * Checks if the pile contains the current card
     * @return true if it does, false if not
     * @author Harsh
     */
    public boolean hasCurrentCard()
    {
        return currentCard != 0; 
    }
    
    /**
     * Gets current value of the card that's in play
     * @return the value of the current card
     * @author Harsh
     */
    public int getCurrentCard()
    {
        return currentCard;
    }
    
    /**
     * Gets the number of cards that are currenetly in pile
     * @return the number of cards in pile
     * @author Harsh
     */
    public int getNumOfCards()
    {
        return currentPile.size();
    }

}
