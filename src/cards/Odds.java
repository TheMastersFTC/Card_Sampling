package cards;

/**
 * Created by chloe Josien and Kylee Fluckiger
 * this class computes the odds for texas hold'em, an exhaustive solution
 * and a stochastic solution
 */
public class Odds {

    /**
     * computes the odds of a hand beating another hand
     *
     * @param h1c1 - position of card one
     * @param h1c2 - position of card two
     * @param h2c1 - position of card three
     * @param h2h2 - position of card four
     * @param samples - the number of times to run the test
     * @return a double percentage
     */
    public static double odds_to_win(int h1c1, int h1c2,
                                     int h2c1, int h2h2, int samples){
        return -1;
    }

    /**
     * goes through every possible hand and adds to a histogram
     *
     * @param hand_size - whether we're doing 5 or 7 card poker
     * @return - a histogram with the likely hood of getting each type of hand
     */
    public static double[] percentage_per_hand_category_exhaustive(int hand_size){

        double [] histogram = new double[10];

        if(hand_size == 5) {
            for(int first=0; first<48; first++) {
                for(int second=first+1; second<52; second++) {
                    for(int third=second+1; third<52; third++) {
                        for(int fourth=third+1; fourth<52; fourth++) {
                            for(int fifth=fourth+1; fifth<52; fifth++) {

                                Hand hand = new Hand(Deck.deck[first], Deck.deck[second], Deck.deck[third], Deck.deck[fourth], Deck.deck[fifth]);

                                System.out.println(hand.cards);
                                System.out.println(hand.rank);
                                System.out.println(hand.longestStraight());
                                System.out.println(hand.rank.ordinal());

                                histogram[hand.rank.ordinal()]++;

                            }
                        }
                    }
                }
            }
        }

        if(hand_size == 7) {
            for(int first=0; first<46; first++) {
                for(int second=first+1; second<52; second++) {
                    for(int third=second+1; third<52; third++) {
                        for(int fourth=third+1; fourth<52; fourth++) {
                            for(int fifth=fourth+1; fifth<52; fifth++) {
                                for(int sixth = fifth+1; sixth<52; sixth++) {
                                    for(int seventh = sixth+1; seventh<52; seventh++) {

                                        Hand hand = new Hand(Deck.deck[first], Deck.deck[second], Deck.deck[third], Deck.deck[fourth], Deck.deck[fifth], Deck.deck[sixth], Deck.deck[seventh]);
                                        histogram[hand.rank.ordinal()]++;

                                    }
                                }
                            }
                        }
                    }
                }
            }


        }


        int totalHands = 0;

        //Calculate the total number of hands.
        for(int index=0; index<histogram.length; index++) {
            totalHands += histogram[index];
        }

        for(int index=0; index<histogram.length; index++) {
            histogram[index] = histogram[index]/totalHands;
            histogram[index] = histogram[index] * 100;
        }

        return histogram;

    }

    /**
     * calculates the percentage of each hand using stochastic sampling
     *
     * @param hand_size - whether we're doing 5 or 7 card poker
     * @param random_samples - number of times to do the test
     * @return a histogram of percentages 
     */
    public  static double[] percentage_per_hand_category_stochastic(int hand_size, int random_samples){

        double [] histogram = new double[10];

        int totalHands = 0;

        for(int index=0; index<random_samples; index++) {

            Hand hand = new Hand(hand_size);
            histogram[hand.rank.ordinal()]++;
            totalHands++;
            System.out.println(index);

        }

        for(int index=0; index<histogram.length; index++) {
            histogram[index] = histogram[index]/totalHands;
            histogram[index] = histogram[index] * 100;
        }

        return histogram;
    }
}
