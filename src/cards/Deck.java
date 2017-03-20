package cards;

import java.util.HashSet;

/**
 * Created by chloe on 3/14/2017.
 */
public class Deck {
    static HashSet<Integer> set = new HashSet<>();
    static final Card [] deck = new Card[52];

    static {
        for (int count=0; count < 52; count++) {
            Constant.Suit suit;
            if(count<13){
                suit = Constant.Suit.CLUB;
                deck[count]= new Card(suit,value(suit,count));
            }
            else if(count<26){
                suit = Constant.Suit.DIAMOND;
                deck[count]= new Card(suit,value(suit,count));
            }
            else if(count<39){
                suit = Constant.Suit.HEART;
                deck[count]= new Card(suit,value(suit,count));
            }
            else {
                suit = Constant.Suit.SPADE;
                deck[count]= new Card(suit,value(suit,count));
            }
        }
    }
    public static int value(Constant.Suit suit, int num){
        return (num+2)-(13*suit.getMultiplier());
    }
 
    /**
     * checks to see if the position was already added in the set
     * returns true if the position was added.
     *
     * @param position
     * @return
     */
    public static boolean noDublicates(int position){

        if(set.contains(position)==false){
            set.add(position);
            return true;
        }
        return false;
    }

}
