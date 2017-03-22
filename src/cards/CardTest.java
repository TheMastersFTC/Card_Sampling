package cards;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chloe on 3/20/2017.
 */
public class CardTest {

    @Test
    public void deckTest(){
        System.out.println(Deck.deck);
    }

    @Test
    public void handTest(){
        Hand hand = new Hand(7);
        ArrayList<Card> cards = hand.getRandomHand(7);
        for (Card c: cards) {
            System.out.println(c);
        }

    }

    @Test
    public void isDuplicate(){
        Deck.noDublicates(52);
        assertEquals(false, Deck.noDublicates(52));
    }

    @Test
    public void histogramTest() {

        Hand hand = new Hand(7);

       // ArrayList<Card> cards = hand.getRandomHand(5);

        for(Card c : hand.cards) {

            System.out.println(c);

        }

        for(int number : hand.histogram) {
            System.out.println(number);
        }

    }

    @Test
    public void royalFlushTest(){
        Card one = new Card(Constant.Suit.HEART,10);
        Card two = new Card(Constant.Suit.HEART,11);
        Card three = new Card(Constant.Suit.HEART,12);
        Card four = new Card(Constant.Suit.HEART,13);
        Card five = new Card(Constant.Suit.HEART,14);
        Hand hand = new Hand(one, two, three, four, five);
        hand.rank();
        Constant.Ranks ranks = hand.rank;
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
        hand.rank();
        Constant.Ranks ranks = hand.rank;
        assertEquals(Constant.Ranks.ROYAL_FLUSH, hand.rank);
    }

}
