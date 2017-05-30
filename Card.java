/**
 * 
 *  Represents a card in the AviBS project
 *
 *  @author  Harsh
 */
public class Card
{
    int number;
    
    /**
     * Constructs a new card with an associated number
     * @param num number
     * @author Harsh
     */
    public Card(int num)
    {
        number = num;
    }
    
    /**
     * Gets the associated number for the card
     * @return the associated number for the card
     * @author Harsh
     */
    public int getNum()
    {
        return this.number;
    }
    
}