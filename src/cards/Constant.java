package cards;

/**
 * Created by chloe and kylee fluckiger
 * holds all the enums for this project
 */
public class Constant {
    /**
     * holds all the enum of the suit and each has a value to know which 
     * place in the deck they start
     */
    public enum Suit {

        CLUB(0), DIAMOND(1), HEART(2), SPADE(3);

        int multiplier;
        
        // constructor for suit
        private Suit(int multiplier) {
            this.multiplier = multiplier;
        }

        // returns the suit given a multiplier
        public static Suit getSuit(int multiplier) {
            for (Suit suit : values()) {
                if (suit.multiplier == multiplier) {
                    return suit;
                }
            }
            return null;
        }
        // returns the multiplier
        public int getMultiplier() {
            return multiplier;
        }

    }

    /**
     * holds all the enums for ranking
     */
    public enum Ranks {

        ROYAL_FLUSH(9), STRAIGHT_FLUSH(8), FOUR_OF_A_KIND(7),
        FULL_HOUSE(6), FLUSH(5), STRAIGHT(4), THREE_OF_A_KIND(3),
        TWO_PAIRS(2), SINGLE_PAIR(1), HIGH_CARD_ONLY(0);

        int rank;
        // constructor for rank
        private Ranks(int rank) {
            this.rank = rank;
        }
        //returns the rank
        public int getRankValue() {
            return rank;
        }
    }
}

