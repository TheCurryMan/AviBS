import java.util.ArrayList;
import java.util.Scanner;


public class GameController
{
    ArrayList<Player> players;

    Player lastPlayer;

    Pile currentPile;


    public GameController( ArrayList<Player> players )
    {
        this.players = players;
        this.currentPile = new Pile();
    }


    public void nextTurn( Player p )
    {
        System.out.println( currentPile.getPile() );
        System.out.println( "Hey " + p.getName() + "! It's your turn." );
        System.out.println( "Your current hand: " + p.viewHand() );
        ArrayList<Card> play = new ArrayList<Card>();
        System.out.println( "Enter B to call bluff, S to skip and P to play" );
        Scanner user_input = new Scanner( System.in );
        String currendHand = p.viewHand();

        String cur = user_input.next();
        if ( cur.equals( "P" ) )
        {
            if ( currentPile.hasCurrentCard() )
            {
                System.out.println(
                    "The current card is " + currentPile.getCurrentCard() );
            }
            System.out.println( "How many cards do you want to play?" );
            String num = user_input.next();
            char n = num.charAt( 0 );
            int number = Character.getNumericValue( n );
            int type = currentPile.getCurrentCard();
            if ( !currentPile.hasCurrentCard() )
            {
                System.out.println( "What do you want to play them as?" );
                String val = user_input.next();
                char c = val.charAt( 0 );
                type = Character.getNumericValue( c );
            }

            ArrayList<Card> cList = new ArrayList<Card>();
            for ( int i = 0; i < number; i++ )
            {
                System.out.println( "What card do you want to play?" );
                String newCard = user_input.next();
                char c = newCard.charAt( 0 );
                int cardVal = Character.getNumericValue( c );
                cList.add( new Card( cardVal ) );
                p.removeCard( cardVal );

            }
            currentPile.addCards( cList, type );
            players.add( players.remove( 0 ) );
            nextTurn( players.get( 0 ) );

        }
        else if ( cur.equals("B") )
        {
            Player p1 = currentPile.bluffCalled( players.get( 0 ),
                players.get( players.size() - 1 ) );
            if ( p1 == players.get( 0 ) )
            {   
                System.out.println( "You were right! " + players.get( players.size()-1 ).getName() + " has taken all the cards in the Pile");
                nextTurn( players.get( 0 ) );
            } else {
                System.out.println("Whoops. " + players.get( players.size()-1 ).getName() + " had actually played the right cards. You've taken all the cards in the Pile");
                players.add(0, players.remove( players.size()-1 ) );
                nextTurn( players.get( 0 ) );
            }

        }
        else if ( cur.equals("S") )
        {
            players.add( players.remove( 0 ) );
            nextTurn( players.get( 0 ) );
        }

    }
    
    public static void distribute( ArrayList<Player> p, Deck d )
    {
        int counter = 1;
        for ( Card c : d.getDeck() )
        {
            p.get( counter % p.size() ).addCard( c );
            counter++;
        }
    }

    public static void main( String[] args )
    {
        Player p1 = new Human( "Avi" );
        Player p2 = new Human( "Susan" );
        Player p3 = new Human( "Harsh" );
        Player p4 = new Bot("Bob");
        ArrayList<Player> players = new ArrayList<Player>();
        players.add( p1 );
        players.add( p2 );
        players.add( p3 );

        GameController game = new GameController( players );

        Deck d = new Deck();
        distribute( players, d );

        game.nextTurn( p1 );

    }

}
