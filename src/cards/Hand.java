package cards;

import static cards.Deck.deck;

/**
 * Created by chloe on 3/14/2017.
 */
public class Hand {

    Card [] cards = new Card[7];
    Card [] hand1 = new Card[7];
    Card [] hand2 = new Card[7];

    public Card[] getRandomHand(int cardNum){
        int position;
        for(int num=0; num<cardNum; num++){

            position = (int)(Math.random()*52);

            while(Deck.noDublicates(position)==false){
                position = (int)(Math.random()*52);
            }
            cards[num]= deck[position];
        }

        return cards;
    }

    public void getTwoRandomHands(Card [] hand1, Card [] hand2){
        Card [] tableHand = getRandomHand(5);
        for(int num=0; num<tableHand.length; num++){
            hand1[num+2] = tableHand[num];
            hand2[num+2] = tableHand[num];
        }
        // add more stuff
    }

    public void value(){

    }

    public Card[] sort(Card[] cards) {

        Card temp;
        int length;

        if(cards[6]==null) {
             length = 5;
        }

        else {
             length = 7;
        }

        for(int i=1; i<length; i++) {
            for (int inner=i; inner > 0; inner--) {
                if (cards[inner].getValue() < cards[inner - 1].getValue()) {
                    temp = cards[inner];
                    cards[inner] = cards[inner - 1];
                    cards[inner - 1] = temp;
                }
            }
        }
        return cards;
    }

    public void createHand(int first, int second, int third, int fourth, int fifth){

    }


}
