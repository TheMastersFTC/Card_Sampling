package cards;

/**
 * Created by chloe Josien and kylee Fluckiger
 * builds a card with a suit and a value
 */
public class Card {
    private Constant.Suit suit;
    private int value;

    /**
     * constructs a card
     * 
     * @param suit - the suit of a card
     * @param value- and the value
     */
    public Card(Constant.Suit suit, int value){
        this.suit=suit;
        this.value=value;
    }

    /**
     * finds the position in the deck
     * 
     * @return - the position
     */
    public int positionInDeck(){
        if(value==1){
            return (13*suit.getMultiplier())+12;
        }
        else{
           return (13*suit.getMultiplier())+ value -2;
        }
    }

    /**
     * gets the value of the card
     * @return - the vlaue
     */
    public int getValue() {
        return value;
    }

    /**
     * gets the suit of the card
     * @return - the suit
     */
    public Constant.Suit getSuit() {
        return suit;
    }

    /**
     * checks if the cards are equal
     * @param secondCard
     * @return
     */
    public boolean equals(Card secondCard){
        return positionInDeck()== secondCard.positionInDeck();
    }

    /**
     * displays the suit and value
     * @return
     */
    public String toString(){
        return "the suit is:" + suit + "the value is:" + value;
    }
}
