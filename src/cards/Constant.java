package cards;

/**
 * Created by chloe on 3/18/2017.
 */
public class Constant {
    public enum Suit {

        CLUB(0), DIAMOND(1), HEART(2), SPADE(3);

        int multiplier;

        private Suit(int multiplier) {
            this.multiplier = multiplier;
        }

        public static Suit getSuit(int multiplier) {
            for (Suit suit : values()) {
                if (suit.multiplier == multiplier) {
                    return suit;
                }
            }
            return null;
        }

        public int getMultiplier() {
            return multiplier;
        }

    }

    public enum Ranks {
        //        ROYAL_FLUSH, STRAIGHT_FLUSH, FOUR_OF_A_KIND,
//        FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND,
//         TWO_PAIRS, SINGLE_PAIR, HIGH_CARD_ONLY;
        ROYAL_FLUSH(9), STRAIGHT_FLUSH(8), FOUR_OF_A_KIND(7),
        FULL_HOUSE(6), FLUSH(5), STRAIGHT(4), THREE_OF_A_KIND(3),
        TWO_PAIRS(2), SINGLE_PAIR(1), HIGH_CARD_ONLY(0);

        int rank;

        private Ranks(int rank) {
            this.rank = rank;
        }

        public int getRankValue() {
            return rank;
        }
    }
}

