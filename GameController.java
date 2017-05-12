import java.util.ArrayList;
import java.util.Scanner;

public class GameController
{
    Player currentPlayer;
    ArrayList<Player> players;
    Player lastPlayer;
    public GameController(ArrayList<Player> players)
    {
        this.players = players;
        this.currentPlayer = players.get(0);
    }
    
    public static void nextTurn(Player p)
    {
        System.out.println("Hey " + p.getName() + "! It's your turn.");
        System.out.println("Your current hand: " + p.viewHand());
        ArrayList<Card> play = new ArrayList<Card>();
        System.out.println("Enter B to call bluff, S to skip and P to play");
        Scanner user_input = new Scanner(System.in);
        String currendHand = p.viewHand();
        
        String cur = user_input.next();
        if (cur == "P")
        {
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
        } else if (cur == "B")
        {
            
        } else if (cur == "S") {
            
        }
        
        
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
        
        GameController game = new GameController(players);
        
        Deck d = new Deck();
        distribute(players, d);
        
        nextTurn(p1);
        
        
    }
    
    
}

