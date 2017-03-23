package cards;

/**
 * Created by chloe on 3/14/2017.
 */
public class Odds {

    public static double odds_to_win(int h1c1, int h1c2,
                                     int h2c1, int h2h2, int samples){
        return -1;
    }

    public static double[] percentage_per_hand_category_exhaustive(int hand_size){

        double [] histogram = new double[10];

        if(hand_size == 5) {
            for(int first=0; first<48; first++) {
                for(int second=first+1; second<52; second++) {
                    for(int third=second+1; third<52; third++) {
                        for(int fourth=third+1; fourth<52; fourth++) {
                            for(int fifth=fourth+1; fifth<52; fifth++) {

                                Hand hand = new Hand(Deck.deck[first], Deck.deck[second], Deck.deck[third], Deck.deck[fourth], Deck.deck[fifth]);
                                histogram[hand.rank.ordinal()]++;

                            }
                        }
                    }
                }
            }
        }

        if(hand_size == 7) {
            for(int first=0; first<48; first++) {
                for(int second=first+1; second<52; second++) {
                    for(int third=second+1; third<52; third++) {
                        for(int fourth=third+1; fourth<52; fourth++) {
                            for(int fifth=fourth+1; fifth<52; fifth++) {
                                for(int sixth = fifth+1; sixth<52; sixth++) {
                                    for(int seventh = sixth+1; seventh<52; seventh++) {

                                        Hand hand = new Hand(Deck.deck[first], Deck.deck[second], Deck.deck[third], Deck.deck[fourth], Deck.deck[fifth]);
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
        }

        return histogram;

    }

    public  static double[] percentage_per_hand_catergory_stochastic(int hand_size, int random_samples){
        double [] histogram = new double[10];

        for(int count=0; count<random_samples; count++){
            Hand hand = new Hand(5);

            histogram[hand.rank.getRankValue()]++;
        }
        return histogram;
    }
}
