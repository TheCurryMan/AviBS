import java.util.ArrayList;

public class GameController
{
    public GameController()
    {
        
    }

    public static void distribute(ArrayList<Player> p, Deck d)
    {
        int counter = 1;
        for (Card c: d.getDeck()) 
        {
            p.get( counter % p.size()).addCard( c );
            counter++;
        }
    }
    
    
    public static void main (String[] args) 
    {
        Player p1 = new Player("Avi");
        Player p2 = new Player("Susan");
        Player p3 = new Player("Harsh");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add( p1 );
        players.add( p2 );
        players.add( p3 );
        Deck d = new Deck();
        distribute(players, d);
        
        System.out.println(p1.viewHand());
        System.out.println(p2.viewHand());
        System.out.println(p3.viewHand());
        
    }
    
    
}

