package cards;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chloe Josien and Kylee fluckiger
 * tests the card and hand classes
 */
public class CardTest {

//    @Test
//    public void deckTest(){
//        System.out.println(Deck.deck);
//    }
//
//    @Test
//    public void handTest(){
//        Hand hand = new Hand(7);
//        ArrayList<Card> cards = hand.getRandomHand(7);
//        for (Card c: cards) {
//            System.out.println(c);
//        }
//
//    }

//    @Test
//    public void isDuplicate(){
//        Hand hand = new Hand();
//        hand.noDuplicates(52);
//        assertEquals(false, hand.noDuplicates(52));
//    }

//    @Test
//    public void histogramTest() {
//
//        Hand hand = new Hand(7);
//
//        for(Card c : hand.cards) {
//            System.out.println(c);
//        }
//
//        for(int number : hand.histogram) {
//            System.out.println(number);
//        }
//    }

    @Test
    public void royalFlushTest(){
        Card one = new Card(Constant.Suit.HEART,10);
        Card two = new Card(Constant.Suit.HEART,11);
        Card three = new Card(Constant.Suit.HEART,12);
        Card four = new Card(Constant.Suit.HEART,13);
        Card five = new Card(Constant.Suit.HEART,14);
        Hand hand = new Hand(one, two, three, four, five);

        assertEquals(Constant.Ranks.ROYAL_FLUSH, hand.rank);
    }

    @Test
    public void royalFlushTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,10);
        Card two = new Card(Constant.Suit.HEART,11);
        Card three = new Card(Constant.Suit.HEART,12);
        Card four = new Card(Constant.Suit.HEART,13);
        Card five = new Card(Constant.Suit.HEART,14);
        Card six = new Card(Constant.Suit.CLUB,3);
        Card seven = new Card(Constant.Suit.SPADE,4);
        Hand hand = new Hand(seven, three, four, two, five,six,one);

        assertEquals(Constant.Ranks.ROYAL_FLUSH, hand.rank);
    }

    @Test
    public void straighFlushTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.HEART,3);
        Card three = new Card(Constant.Suit.HEART,4);
        Card four = new Card(Constant.Suit.HEART,5);
        Card five = new Card(Constant.Suit.HEART,6);
        Hand hand = new Hand(one, two, three, four, five);

        assertEquals(Constant.Ranks.STRAIGHT_FLUSH, hand.rank);
    }

    @Test
    public void straightFlushTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,1);
        Card two = new Card(Constant.Suit.HEART,2);
        Card three = new Card(Constant.Suit.HEART,3);
        Card four = new Card(Constant.Suit.HEART,4);
        Card five = new Card(Constant.Suit.HEART,5);
        Card six = new Card(Constant.Suit.CLUB,7);
        Card seven = new Card(Constant.Suit.SPADE,8);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.STRAIGHT_FLUSH, hand.rank);
    }

    @Test
    public void fourOfAKindTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.SPADE,2);
        Card four = new Card(Constant.Suit.DIAMOND,2);
        Card five = new Card(Constant.Suit.HEART,6);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.FOUR_OF_A_KIND, hand.rank);
    }

    @Test
    public void fourOfAKindTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.SPADE,2);
        Card four = new Card(Constant.Suit.DIAMOND,2);
        Card five = new Card(Constant.Suit.HEART,5);
        Card six = new Card(Constant.Suit.CLUB,3);
        Card seven = new Card(Constant.Suit.SPADE,4);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.FOUR_OF_A_KIND, hand.rank);
    }

    @Test
    public void fullHouseTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.SPADE,2);
        Card four = new Card(Constant.Suit.SPADE,6);
        Card five = new Card(Constant.Suit.HEART,6);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.FULL_HOUSE, hand.rank);
    }

    @Test
    public void fullHouseTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.SPADE,2);
        Card three = new Card(Constant.Suit.SPADE,4);
        Card four = new Card(Constant.Suit.DIAMOND,4);
        Card five = new Card(Constant.Suit.HEART,4);
        Card six = new Card(Constant.Suit.CLUB,7);
        Card seven = new Card(Constant.Suit.SPADE,6);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.FULL_HOUSE, hand.rank);
    }

    //doesn't work fix this
    @Test
    public void flushTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.HEART,5);
        Card three = new Card(Constant.Suit.HEART,7);
        Card four = new Card(Constant.Suit.HEART,9);
        Card five = new Card(Constant.Suit.HEART,6);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.FLUSH, hand.rank);
    }

    @Test
    public void flushTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.HEART,5);
        Card three = new Card(Constant.Suit.HEART,7);
        Card four = new Card(Constant.Suit.HEART,9);
        Card five = new Card(Constant.Suit.HEART,6);
        Card six = new Card(Constant.Suit.CLUB,3);
        Card seven = new Card(Constant.Suit.SPADE,4);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.FLUSH, hand.rank);
    }

    @Test
    public void straightTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,3);
        Card three = new Card(Constant.Suit.HEART,5);
        Card four = new Card(Constant.Suit.SPADE,4);
        Card five = new Card(Constant.Suit.DIAMOND,6);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.STRAIGHT, hand.rank);
    }

    @Test
    public void straightTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,3);
        Card three = new Card(Constant.Suit.HEART,5);
        Card four = new Card(Constant.Suit.SPADE,4);
        Card five = new Card(Constant.Suit.DIAMOND,6);
        Card six = new Card(Constant.Suit.CLUB,3);
        Card seven = new Card(Constant.Suit.SPADE,4);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.STRAIGHT, hand.rank);
    }

    @Test
    public void threeOfAKindTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.HEART,5);
        Card four = new Card(Constant.Suit.SPADE,4);
        Card five = new Card(Constant.Suit.DIAMOND,2);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.THREE_OF_A_KIND, hand.rank);
    }

    @Test
    public void threeOfAKindTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.HEART,7);
        Card four = new Card(Constant.Suit.SPADE,2);
        Card five = new Card(Constant.Suit.DIAMOND,6);
        Card six = new Card(Constant.Suit.CLUB,10);
        Card seven = new Card(Constant.Suit.SPADE,14);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.THREE_OF_A_KIND, hand.rank);
    }

    @Test
    public void twoPairsTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.HEART,4);
        Card four = new Card(Constant.Suit.SPADE,4);
        Card five = new Card(Constant.Suit.DIAMOND,7);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.TWO_PAIRS, hand.rank);
    }

    @Test
    public void twoPairsTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.HEART,7);
        Card four = new Card(Constant.Suit.SPADE,8);
        Card five = new Card(Constant.Suit.DIAMOND,6);
        Card six = new Card(Constant.Suit.CLUB,6);
        Card seven = new Card(Constant.Suit.SPADE,14);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.TWO_PAIRS, hand.rank);
    }

    @Test
    public void singlePairTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.HEART,8);
        Card four = new Card(Constant.Suit.SPADE,4);
        Card five = new Card(Constant.Suit.DIAMOND,7);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.SINGLE_PAIR, hand.rank);
    }

    @Test
    public void singlePairTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,2);
        Card three = new Card(Constant.Suit.HEART,7);
        Card four = new Card(Constant.Suit.SPADE,8);
        Card five = new Card(Constant.Suit.DIAMOND,1);
        Card six = new Card(Constant.Suit.CLUB,6);
        Card seven = new Card(Constant.Suit.SPADE,14);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.SINGLE_PAIR, hand.rank);
    }

    @Test
    public void highestCardOnlyTest(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,6);
        Card three = new Card(Constant.Suit.HEART,1);
        Card four = new Card(Constant.Suit.SPADE,4);
        Card five = new Card(Constant.Suit.DIAMOND,7);
        Hand hand = new Hand(one, two, three, four, five);
        assertEquals(Constant.Ranks.HIGH_CARD_ONLY, hand.rank);
    }

    @Test
    public void highestCardOnlyTestSevenCards(){
        Card one = new Card(Constant.Suit.HEART,2);
        Card two = new Card(Constant.Suit.CLUB,6);
        Card three = new Card(Constant.Suit.HEART,7);
        Card four = new Card(Constant.Suit.SPADE,8);
        Card five = new Card(Constant.Suit.DIAMOND,1);
        Card six = new Card(Constant.Suit.CLUB,10);
        Card seven = new Card(Constant.Suit.SPADE,14);
        Hand hand = new Hand(seven, three, four, two, five,six,one);
        assertEquals(Constant.Ranks.HIGH_CARD_ONLY, hand.rank);
    }
}
