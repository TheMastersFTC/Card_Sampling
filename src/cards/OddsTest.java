package cards;
import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chloe Josien and Kylee fluckiger
 * tests the odds class 
 */
public class OddsTest {

//    @Test
//    public void percentageExhaustiveTest() {
//
//    	double [] histogram = Odds.percentage_per_hand_category_exhaustive(5);
//    	for(double bin : histogram) {
//    		System.out.println(bin);
//    	}
//    }

    @Test
    public void percentageExhaustiveTestSeven(){

        double [] histogram = Odds.percentage_per_hand_category_exhaustive(7);
        for(double bin : histogram) {
            System.out.println(bin);
        }
    }

//    @Test
//    public void hierarchy() {
//
//        Card one = new Card(Constant.Suit.CLUB,2);
//        Card two = new Card(Constant.Suit.CLUB,3);
//        Card three = new Card(Constant.Suit.CLUB,10);
//        Card four = new Card(Constant.Suit.CLUB,11);
//        Card five = new Card(Constant.Suit.CLUB,12);
//        Card six = new Card(Constant.Suit.CLUB,13);
//        Card seven = new Card(Constant.Suit.DIAMOND, 14);
//
//        Hand hand = new Hand(one, two, three, four, five, six, seven);
//
//        System.out.println(hand.rank);
//
//    }

//  @Test
//  public void hierarchy() {
//
//      Card one = new Card(Constant.Suit.DIAMOND,1);
//      Card two = new Card(Constant.Suit.HEART,1);
//      Card three = new Card(Constant.Suit.HEART,2);
//      Card four = new Card(Constant.Suit.HEART,3);
//      Card five = new Card(Constant.Suit.HEART,4);
//      Card six = new Card(Constant.Suit.HEART,5);
//      Card seven = new Card(Constant.Suit.HEART, 6);
//
//      Hand hand = new Hand(one, two, three, four, five, six, seven);
//
//      System.out.println(hand.rank);
//      System.out.println(hand.longestStraight());
//
    //}

//    @Test
//    public void stochasticFive(){
//
//    	double [] histogram = Odds.percentage_per_hand_catergory_stochastic(7, 1_000_000);
//    	for(double bin : histogram) {
//    		System.out.println(bin);
//    	}
//    }

}
