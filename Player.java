
public class Player
{
    private String name;
    private Hand currentHand;
    
    public Player() 
    {
        
    }
    
    public Player(String name)
    {
        this.name = name;
        this.currentHand = new Hand();
    }
    
    public void addCard(Card c) {
        this.currentHand.addCard( c );
    }
    
    

}