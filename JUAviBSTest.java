import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.JUnit4TestAdapter;


public class JUAviBSTest extends CardComparator
{
    @Test
    public void botConstructor()// *
    {
        Bot bob = new Bot( "bob" );
        assertNotNull( "<< Invalid Bot Constructor >>", bob );
    }


    @Test
    public void cardConstructor()// *
    {
        Card c = new Card( 1 );
        assertNotNull( "<< Invalid Card Constructor >>", c );
    }


    @Test
    public void cardGetNum()// *
    {
        Card c = new Card( 1 );
        assertEquals( "<< Invalid Card getNum method >>", c.getNum(), 1 );
    }


    @Test
    public void cardComparator()// *
    {

        Card a = new Card( 2 );
        Card b = new Card( 1 );
        assertTrue( "<< Invalid cardComparator Constructor >>",
            compare( b, a ) < 0 );
    }


    @Test
    public void deckConstructor()// *
    {
        Deck d = new Deck();
        assertNotNull( "<< Invalid Deck Constructor >>", d );
    }


    @Test
    public void deckShuffle()// ** (how do you test random shuffling?)
    {

    }


    @Test
    public void deckGetDeck()// *
    {
        Deck d = new Deck();
        assertTrue( "<< Invalid Deck getDeck method >>",
            d.getDeck().size() == 52 );
    }


    @Test
    public void gameControllerConstructor()// *
    {
        ArrayList<Player> p = new ArrayList<Player>();
        GameController game = new GameController( p );
        assertNotNull( "<< Invalid GameController Constructor >>", game );
    }


    @Test
    public void gameControllerDistribute()// *
    {
        ArrayList<Player> p = new ArrayList<Player>();
        Player p1 = new Human( "Avi" );
        Player p2 = new Human( "Susan" );
        Player p3 = new Human( "Harsh" );
        p.add( p1 );
        p.add( p2 );
        p.add( p3 );
        GameController game = new GameController( p );
        Deck d = new Deck();
        game.distribute( p, d );
        assertTrue( "<< Invalid GameController Constructor >>",
            p1.getHand().size() == 17
                || p1.getHand().size() == 18 && p2.getHand().size() == 17
                || p2.getHand().size() == 18 && p3.getHand().size() == 17
                || p3.getHand().size() == 18 );
    }


    @Test
    public void handConstructor()// *
    {
        Hand h = new Hand();
        assertNotNull( "<< Invalid Hand Constructor >>", h );
    }


    @Test
    public void handRemoveNum()// *
    {
        Hand h = new Hand();
        h.addCard( new Card( 1 ) );
        h.addCard( new Card( 1 ) );
        h.addCard( new Card( 2 ) );
        h.removeNum( 1 );
        assertTrue( "<< Invalid Hand removeNum method >>",
            h.getHand().size() == 2 );
    }


    @Test
    public void handAddCard()// *
    {
        Hand h = new Hand();
        h.add( 1 );
        h.add( 2 );
        assertTrue( "<< Invalid Hand addCard method >>",
            h.contains( 1 ) && h.contains( 2 ) && h.size() == 2 );
    }


    @Test
    public void handAddCards()// *
    {
        Hand h = new Hand();
        ArrayList<Card> c = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        c.add( c1 );
        h.addCards( c );
        assertTrue( "<< Invalid Hand getHand method >>",
            h.getHand().toString().contains( "[Card@" ) );
    }


    @Test
    public void handGetHand()// *
    {
        Hand h = new Hand();
        ArrayList<Card> c = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        c.add( c1 );
        h.addCards( c );
        assertTrue( "<< Invalid Hand getHand method >>",
            h.getHand().toString().contains( "[Card@" ) );
    }


    @Test
    public void handViewHand()// *
    {
        Hand h = new Hand();
        h.addCard( new Card( 1 ) );
        h.addCard( new Card( 1 ) );
        assertTrue( "<< Invalid Hand viewHand method >>",
            h.viewHand().equals( " 1 1" ) );
    }


    @Test
    public void handContains()// *
    {
        Hand h = new Hand();
        h.add( 1 );
        h.add( 2 );
        assertTrue( "<< Invalid Hand Contains method >>", h.contains( 1 ) );
        assertFalse( "<< Invalid Hand Contains method >>", h.contains( 0 ) );
    }


    @Test
    public void humanConstructor()// *
    {
        Human h = new Human( "joe" );
        assertNotNull( "<< Invalid Human Constructor >>", h );
    }


    @Test
    public void pileConstructor()// *
    {
        Pile p = new Pile();
        assertNotNull( "<< Invalid Pile Constructor >>", p );
    }


    @Test
    public void pileAddCards()// *
    {
        Pile p = new Pile();
        ArrayList<Card> cards = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        Card c3 = new Card( 3 );
        cards.add( c1 );
        cards.add( c2 );
        cards.add( c3 );
        p.addCards( cards, 1 );
        assertTrue( "<< Invalid Pile addCards method >>",
            p.getPile().equals( "1 2 3 " ) );
    }


    @Test
    public void pileGetLastAdd()// *
    {
        Pile p = new Pile();
        ArrayList<Card> cards = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        Card c3 = new Card( 3 );
        cards.add( c1 );
        p.addCards( cards, 1 );

        cards.add( c2 );
        p.addCards( cards, 1 );

        cards.add( c3 );
        p.addCards( cards, 1 );

        System.out.println( p.getLastAdd() );
        assertTrue( "<< Invalid Pile getLastAdd method >>",
            p.getLastAdd().equals( "1 2 3 " ) );
    }


    @Test
    public void pileGetPile()// *
    {
        Pile p = new Pile();
        ArrayList<Card> cards = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        Card c3 = new Card( 3 );
        cards.add( c1 );
        p.addCards( cards, 1 );
        cards.clear();
        cards.add( c2 );
        p.addCards( cards, 1 );
        cards.clear();
        cards.add( c3 );
        p.addCards( cards, 1 );
        cards.clear();
        assertTrue( "<< Invalid Pile getPile method >>",
            p.getPile().length() == 6 );
    }


    @Test
    public void pileHasCurrentCard()// * (do i have to check all the conditions
                                    // :/)
    {
        Pile p = new Pile();
        ArrayList<Card> cards = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        Card c3 = new Card( 3 );
        cards.add( c1 );
        p.addCards( cards, 1 );
        cards.clear();
        cards.add( c2 );
        p.addCards( cards, 1 );
        cards.clear();
        assertTrue( "<< Invalid Pile hasCurrentCard method >>",
            p.hasCurrentCard() );
    }


    @Test
    public void pileGetCurrentCard()// *
    {
        Pile p = new Pile();
        ArrayList<Card> cards = new ArrayList<Card>();
        Card c1 = new Card( 1 );
        Card c2 = new Card( 2 );
        Card c3 = new Card( 3 );
        cards.add( c1 );
        p.addCards( cards, 1 );
        cards.clear();
        cards.add( c2 );
        p.addCards( cards, 1 );
        cards.clear();
        assertTrue( "<< Invalid Pile getCurrentCard method >>",
            p.getCurrentCard() == 1 );
    }

    @Test
    public void playerConstructorParams()// *
    {
        Player p = new Human( "joe" );
        assertNotNull( "<< Invalid Player constructor >>", p );
    }


    @Test
    public void playerAddCard()// *
    {
        Player p = new Human( "joe" );
        Card c = new Card( 1 );
        p.addCard( c );
        assertTrue( "<< Invalid Player addCard method >>",
            p.viewHand().equals( " 1" ) );
    }


    @Test
    public void playerViewHand()// *
    {
        Player p = new Human( "joe" );
        Card c = new Card( 1 );
        p.addCard( c );
        assertTrue( "<< Invalid Player addCard method >>",
            p.viewHand().equals( " 1" ) );
    }


    @Test
    public void playerGetHand()// *
    {
        Player p = new Human( "joe");
        Card c = new Card( 1 );
        p.addCard( c );
        ArrayList<Card> a = new ArrayList<Card>();
        a.add( c );
        assertTrue( "<< Invalid Player getHand method >>",
            p.getHand().equals( a ) );
    }


    @Test
    public void playerGetName()// *
    {
        Player p = new Human( "joe" );
        assertTrue( "<< Invalid Player getName method >>",
            p.getName().equals( "joe" ) );
    }


    @Test
    public void playerAddCards()// *
    {
        Player p = new Human( "joe" );
        Card c = new Card( 1 );
        Card c2 = new Card( 2 );
        ArrayList<Card> a = new ArrayList<Card>();
        a.add( c );
        a.add( c2 );
        p.addCards( a );
        assertTrue( "<< Invalid Player addCards method >>",
            p.viewHand().equals( " 1 2" ) );
    }


    @Test
    public void playerRemoveCard()// *
    {
        Player p = new Human( "joe" );
        Card c = new Card( 1 );
        Card c2 = new Card( 2 );
        ArrayList<Card> a = new ArrayList<Card>();
        a.add( c );
        a.add( c2 );
        p.addCards( a );
        p.removeCard( 2 );
        assertTrue( "<< Invalid Player removeCard method >>",
            p.viewHand().equals( " 1" ) );
    }


    @Test
    public void playerIsBot()// *
    {
        Player p = new Human( "joe" );
        assertTrue( "<< Invalid Player isBot method >>", !p.isBot() );
    }

}
