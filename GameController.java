import java.util.ArrayList;
import java.util.Scanner;

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
    
    
    public void play(Player p)
    {
        ArrayList<Card> play = new ArrayList<Card>();
        Scanner user_input = new Scanner(System.in);
        String currendHand = p.viewHand();
        
        System.out.print( "How many cards do you want to play?" );
        String num = user_input.next();
        char n = num.charAt( 0 );
        int number = Character.getNumericValue(n);
        
        System.out.print( "What do you want to play them as?" );
        String val = user_input.next();
        
        for (int i = 0; i < number; i++)
        {
            System.out.print( "What card do you want to play?" );
            String newCard = user_input.next();
            char c = newCard.charAt( 0 );
            int cardVal = Character.getNumericValue( c );
            
        }
    }
}

