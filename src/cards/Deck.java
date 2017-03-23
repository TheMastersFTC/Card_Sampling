package cards;

/**
 * Created by chloe Josien and kylee Fluckiger
 * creates the deck of cards
 */
public class Deck {

    static final Card[] deck = new Card[52];

    static {
        for (int count = 0; count < 52; count++) {
            Constant.Suit suit;
            if (count < 13) {
                suit = Constant.Suit.CLUB;
                deck[count] = new Card(suit, value(suit, count));
            } else if (count < 26) {
                suit = Constant.Suit.DIAMOND;
                deck[count] = new Card(suit, value(suit, count));
            } else if (count < 39) {
                suit = Constant.Suit.HEART;
                deck[count] = new Card(suit, value(suit, count));
            } else {
                suit = Constant.Suit.SPADE;
                deck[count] = new Card(suit, value(suit, count));
            }
        }
    }

    /**
     * returns the value on the card
     *
     * @param suit
     * @param num
     * @return
     */
    public static int value(Constant.Suit suit, int num) {
        return (num + 2) - (13 * suit.getMultiplier());
    }

}
