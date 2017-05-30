import java.util.Comparator;
/**
 * Compares the value associated with the cards
 *
 *  @author  Harsh
 */
public class CardComparator implements Comparator<Card>
{
    @Override
    /**
     * the value 0 if o1 == o2; a value less than 0 if o1 < o2; and a value greater than 0 if o1 > o2
     * @author Harsh 
     */
    public int compare( Card o1, Card o2 )
    {
        
        return Integer.compare( o1.getNum(), o2.getNum());
    }
}
