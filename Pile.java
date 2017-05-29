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
    
    public String getLastAdd()
    {
        String str = "";
        for (Card c : lastAdd)
        {
            str = str + c.getNum() + " ";
        }
        return str;
    }
    
    public String getPile()
    {
        String str = "";
        for (Card c : currentPile)
        {
            str = str + c.getNum() + " ";
        }
        return str;
    }
    
    public ArrayList<Card> emptyPile()
    {
        return null;
    }
    
    public boolean hasCurrentCard()
    {
        return currentCard != 0; 
    }
    
    public int getCurrentCard()
    {
        return currentCard;
    }
    
    public int getNumOfCards()
    {
        return currentPile.size();
    }

}
