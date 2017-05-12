import java.util.ArrayList;

public class Pile
{
    ArrayList<Card> currentPile;
    ArrayList<Card> lastAdd;
    int currentCard;
    
    public Pile()
    {
        currentPile = new ArrayList<Card>();
        lastAdd = currentPile;
        currentCard = 0;
    }
    
    public void addCards(ArrayList<Card> c, int type) 
    {
        if (currentPile.size() == 0)
        {
            currentCard = type;
        }
        currentPile.addAll( c );
        lastAdd = c;
    }
    
    public Player bluffCalled(Player currentPlayer, Player lastPlayer)
    {
        for (Card c: lastAdd)
        {
            if (c.getNum() != currentCard) 
            {
                lastPlayer.addCards( currentPile );
                currentPile.clear();
                lastAdd.clear();
                return currentPlayer;
            }             
        }
        currentPlayer.addCards( currentPile );
        currentPile.clear();
        lastAdd.clear();
        return lastPlayer;
    }

}
