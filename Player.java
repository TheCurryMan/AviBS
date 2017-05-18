import java.util.ArrayList;

public class Player
{
    private String name;
    private Hand currentHand;
    private boolean isHuman;
    
    private ArrayList<Integer> singles = new ArrayList<Integer>();
    private ArrayList<Integer> doubles = new ArrayList<Integer>();
    private ArrayList<Integer> triples = new ArrayList<Integer>();
    private ArrayList<Integer> quadriples = new ArrayList<Integer>();
    
    public Player() 
    {
        
    }
    
    public Player(String name, boolean type)
    {
        this.name = name;
        this.currentHand = new Hand();
    }
    
    public void addCard(Card c) {
        this.currentHand.addCard( c );
    }
    
    public String viewHand() {
        return currentHand.viewHand();
    }
    
    public ArrayList<Card> getHand()
    {
        return this.currentHand.getHand();
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public void addCards(ArrayList<Card> cards)
    {
        this.currentHand.addCards(cards);
    }
    
    public void removeCard(int c) {
        this.currentHand.removeNum( c );
    }
    
    public boolean isBot()
    {
        return !isHuman;
    }
    
    public void sortCards()
    {
        singles.clear();
        doubles.clear();
        triples.clear();
        quadriples.clear();
        for (int i = 1; i < 13; i++)
        {
            int counter = 0;
            for (Card c : this.currentHand.hand)
            {
                if (i == c.getNum())
                {
                    counter++;
                }
            }
            switch (counter)
            {
                case 1: 
                    singles.add( i );
                    break;
                case 2:
                    doubles.add( i );
                    break;
                case 3: 
                    triples.add( i );
                    break;
                case 4:
                    quadriples.add( i );
                    break;
                default:
                    counter = 0;
                    break;
            }
        }
        
        System.out.println( singles );
        System.out.println( doubles );
        System.out.println( triples );
        System.out.println( quadriples );
        
    }
    
    public void BotPlay(int currentCard)
    {
        
        ArrayList<Card> c = new ArrayList<Card>();
        if (quadriples.size() > 0)
        {
            for (int i = 0; i < 4; i++)
            {
                c.add( new Card(quadriples.get( 0 )) );
                quadriples.remove( 0 );
            }
        }
        else if (triples.size() > 0)
        {
            for (int i = 0; i < 3; i++)
            {
                c.add( new Card(triples.get( 0 )) );
                triples.remove( 0 );
            }
        }
    }
    
//    public Card playCard (String input)
//    {
//        if(viewHand().contains( input ))
//        {
//            
//        }
//        
//    }
    

}
