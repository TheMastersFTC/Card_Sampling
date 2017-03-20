package cards;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by chloe on 3/20/2017.
 */
public class CardTest {

//    @Test
//    public void deckTest(){
//        System.out.println(Deck.deck);
//    }

    @Test
    public void handTest(){
        Hand hand = new Hand();
        Card [] cards = hand.getRandomHand(7);
        for (Card c: cards) {
            System.out.println(c);
        }
    }

    @Test
    public void isDuplicate(){
        Deck.noDublicates(52);
        assertEquals(false, Deck.noDublicates(52));
    }
}
