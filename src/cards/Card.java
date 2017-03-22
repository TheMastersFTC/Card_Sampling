package cards;

/**
 * Created by chloe on 3/14/2017.
 */
public class Card {
    private Constant.Suit suit;
    private int value;

    public Card(Constant.Suit suit, int value){
        this.suit=suit;
        this.value=value;
    }

    public int positionInDeck(){
        if(value==1){
            return (13*suit.getMultiplier())+12;
        }
        else{
           return (13*suit.getMultiplier())+ value -2;
        }
    }

    public int getValue() {

        return value;

    }

    public Constant.Suit getSuit() {
        return suit;
    }

    public boolean equals(Card secondCard){
        return positionInDeck()== secondCard.positionInDeck();
    }

    public String toString(){
        return "the suit is:" + suit + "the value is:" + value;
    }
}
