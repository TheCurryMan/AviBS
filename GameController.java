import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 *  The main class for the AviBS application
 *
 *  @author  Avi, Susan, Harsh
 */
public class GameController
{
    ArrayList<Player> players;

    Player lastPlayer;

    Player last = new Human( "" );

    Pile currentPile;

    /**
     * Constructs a new GameController with an ArrayList of the players who
     * will be participating in the game. Initializes currentPile to an empty pile. 
     * @param players the list of players who will be playing in the game
     * @author Avi
     */
    public GameController( ArrayList<Player> players )
    {
        this.players = players;
        this.currentPile = new Pile();
    }

    /**
     * It first checks to see if the player is a human or a bot. If it's a bot, 
     * Bot's BotPlayCurrentCard method is called and the appropriate response is
     * printed out. If it's a human player, the player's current hand is first printed
     * out. The player is then prompted for an input, and they can play either
     * B for bluff, P for play, or S for skip. If they play B for bluff, then the program 
     * checks to see if they are correct/if the previous player who played a card 
     * actually played what they said they did. If so, the player who called the bluff
     * gets all the cards. If not, the player who played the wrong card gets the pile. 
     * If the player enters S for skip, the next player in the rotation will be prompted
     * to play. If a player enters P for play, then they will be prompted for the 
     * number of cards they want to play and the actual cards in their hand that they 
     * are going to play. The program also clears the pile if everyone skips, and if 
     * someone plays/calls a bluff after another player empties their hand, then the 
     * player with the empty hand wins. 
     * @param p Player
     * @author Avi, Susan
     */
    public void nextTurn( Player p )
    {
        System.out.println(" ");
        p.sortCards();
        boolean isEmpty = false;
        String name = last.getName();
        if ( !name.equals( "" ) && last.getHand().isEmpty() )
        {
            isEmpty = true;
        }

        if ( p.isBot() )
        {
            int type;
            if ( currentPile.hasCurrentCard() )
            {
                ArrayList<Card> cList = p
                    .BotPlayCurrentCard( currentPile.currentCard, currentPile );

                if ( cList.size() > 0 && cList.get( 0 ).getNum() == 14 )
                {
                    System.out.println( p.getName() + " called bluff!" );
                    Player p1 = currentPile.bluffCalled( players.get( 0 ),
                        players.get( players.size() - 1 ) );
                    if ( p1 == players.get( 0 ) )
                    {
                        System.out.println(
                            players.get( 0 ).getName() + " was right! "
                                + players.get( players.size() - 1 ).getName()
                                + " has taken all the cards in the Pile" );
                        nextTurn( players.get( 0 ) );
                    }
                    else
                    {
                        System.out.println( "Whoops. "
                            + players.get( players.size() - 1 ).getName()
                            + " had actually played the right cards. You've taken all the cards in the Pile" );
                        players.add( 0, players.remove( players.size() - 1 ) );
                        if ( isEmpty )
                        {
                            System.out.println( last.getHand() + " won!" );
                            System.out.println( "Thanks for playing!" );
                        }
                        else
                        {
                            nextTurn( players.get( 0 ) );
                        }
                    }

                }

                else if ( cList.size() > 0 )
                {
                    type = currentPile.currentCard;
                    System.out.println( p.getName() + " played " + cList.size()
                        + " " + currentPile.currentCard + "'s" );
                    currentPile.addCards( cList, type );

                    if ( isEmpty )
                    {
                        System.out.println( last.getName() + " won!" );
                        System.out.println( "Thanks for playing!" );
                    }
                    else
                    {
                        last = players.get( 0 );
                        players.add( players.remove( 0 ) );
                        nextTurn( players.get( 0 ) );
                    }
                }
                else
                {
                    System.out.println( p.getName() + " skipped" );
                    if ( last.getName().equals( p.getName() ) )
                    {
              
                        if (p.getHand().size() == 0)
                        {
                            isEmpty = true;
                            System.out.println( last.getName() + " won!" );
                            System.out.println( "Thanks for playing!" );
                        } else {
                            
                            currentPile = new Pile();
                            nextTurn( players.get( 0 ) );
                        }
                    }
                    else
                    {
                        players.add( players.remove( 0 ) );
                        nextTurn( players.get( 0 ) );
                    }
                }

            }
            else
            {
                
                ArrayList<Card> cList = p.BotPlayHighest();
                type = cList.remove( 0 ).getNum();
                currentPile.addCards( cList, type );
                System.out.println( p.getName() + " played " + cList.size()
                    + " " + currentPile.currentCard + "'s" );

                if ( isEmpty )
                {
                    System.out.println( last.getName() + " won!" );
                    System.out.println( "Thanks for playing!" );
                }
                else
                {
                    last = players.get( 0 );
                    players.add( players.remove( 0 ) );
                    nextTurn( players.get( 0 ) );
                }
            }

        }

        else
        {
            System.out.println( "Hey " + p.getName() + "! It's your turn." );
            System.out.println( "Your current hand: " + p.viewHand() );
            if ( currentPile.hasCurrentCard() )
            {
                System.out.println(
                    "The current card is " + currentPile.getCurrentCard() );
            }
            System.out
                .println( "Enter B to call bluff, S to skip and P to play" );
            Scanner user_input = new Scanner( System.in );
            String currendHand = p.viewHand();
            String cur = user_input.next();
            int type;
            if ( cur.equals( "P" ) )
            {
                ArrayList<Card> cList = new ArrayList<Card>();

                
                System.out.println( "How many cards do you want to play?" );
                String num = user_input.next();
                int number = Integer.parseInt( num );
                type = currentPile.getCurrentCard();
                if ( !currentPile.hasCurrentCard() )
                {
                    System.out.println( "What do you want to play them as?" );
                    String val = user_input.next();

                    type = Integer.parseInt( val );
                }

                for ( int i = 0; i < number; i++ )
                {
                    System.out.println( "What card do you want to play?" );
                    String newCard = user_input.next();
                    int cardVal = Integer.parseInt( newCard );
                    cList.add( new Card( cardVal ) );
                    p.removeCard( cardVal );

                }

                currentPile.addCards( cList, type );
                if ( isEmpty )
                {
                    System.out.println( last.getName() + " won!" );
                    System.out.println( "Thanks for playing!" );
                }
                else
                {
                    last = players.get( 0 );
                    players.add( players.remove( 0 ) );
                    nextTurn( players.get( 0 ) );
                }

            }
            else if ( cur.equals( "B" ) )
            {
                Player p1 = currentPile.bluffCalled( players.get( 0 ),
                    players.get( players.size() - 1 ) );
                if ( p1 == players.get( 0 ) )
                {
                    System.out.println( "You were right! "
                        + players.get( players.size() - 1 ).getName()
                        + " has taken all the cards in the Pile" );
                    nextTurn( players.get( 0 ) );
                }
                else
                {
                    System.out.println( "Whoops. "
                        + players.get( players.size() - 1 ).getName()
                        + " had actually played the right cards. You've taken all the cards in the Pile" );
                    players.add( 0, players.remove( players.size() - 1 ) );
                    if ( isEmpty )
                    {
                        System.out.println( last.getHand() + " won!" );
                        System.out.println( "Thanks for playing!" );
                    }
                    else
                    {
                        nextTurn( players.get( 0 ) );
                    }
                }

            }
            else if ( cur.equals( "S" ) )
            {
                System.out.println( p.getName() + " skipped" );
                if ( last.getName().equals( p.getName() ) )
                {
                    currentPile = new Pile();
                    nextTurn( players.get( 0 ) );
                }
                else
                {
                    players.add( players.remove( 0 ) );
                    nextTurn( players.get( 0 ) );
                }
            }
        }

    }

    /**
     * This gives each player every third card in the deck. 
     * @param p player
     * @param d deck 
     * @author Harsh
     */
    public static void distribute( ArrayList<Player> p, Deck d )
    {
        int counter = 1;
        for ( Card c : d.getDeck() )
        {
            p.get( counter % p.size() ).addCard( c );
            counter++;
        }

    }

    /**
     * The main method for the AviBS application
     * @param args arguments
     * @author Harsh
     */
    public static void main( String[] args )
    {
        System.out.println( "Welcome to AviBS! Let's begin." );
        
        Player p1 = new Bot( "Avi" );
        Player p2 = new Bot( "Susan" );
        Player p3 = new Bot( "Harsh" );
        Player p4 = new Bot( "Bob" );

        ArrayList<Player> players = new ArrayList<Player>();
        players.add( p1 );
        players.add( p4 );
        players.add( p3 );

        GameController game = new GameController( players );

        Deck d = new Deck();
        distribute( players, d );
        game.nextTurn( players.get( 0 ) );

    }

}
