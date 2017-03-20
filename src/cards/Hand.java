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
        int suit;
        for(int num=0; num<cards.length; num++){
//            suit=(int)(Math.random()*4);
//            position=(int)(Math.random()*13);
//            cards[num]= new Card(Constant.Suit.getSuit(suit), position);

            position = (int)(Math.random()*52);
//            if(Deck.noDublicates(position)){
//                cards[num] = deck [position];
//            }
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
    }

    public void value(){

    }

    public void createHand(int first, int second, int third, int fourth, int fifth){

    }

    public String toString(){
        return "";
    }
}
