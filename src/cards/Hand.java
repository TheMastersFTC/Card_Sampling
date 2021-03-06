package cards;

import java.util.ArrayList;
import java.util.HashSet;

import static cards.Deck.deck;

/**
 * Created by chloe Josien and Kylee Fluckiger
 * this class creates random hands and ranks the hands
 */
public class Hand {

    ArrayList<Card> cards = new ArrayList<>();

    Hand player1;
    Hand player2;

    int [] histogram= new int[14];
    int [] suitHistogram = new int[4];

    Constant.Ranks rank;
    
    double value;

    /**
     * creates a random hand of cardNum
     * @param cardNum - number of cards in the hand
     */
    public Hand(int cardNum) {

        cards = this.getRandomHand(cardNum);
        
        this.sort();
        this.rank();
        this.value();
    }

    /**
     * creates a five card hand and sorts, ranks, and finds the value
     * 
     * @param one - the first card
     * @param two - the second card
     * @param three - the third card
     * @param four - the forth card
     * @param five - the fifth card
     */
    public Hand (Card one, Card two, Card three, Card four, Card five){
        cards.add(one);
        cards.add(two);
        cards.add(three);
        cards.add(four);
        cards.add(five);

        this.sort();
        this.rank();
        this.value();
    }

    /**
     * creates a seven card hand
     * 
     * @param one - the first card
     * @param two - the second card
     * @param three - the third card
     * @param four - the forth card
     * @param five - the fifth card
     * @param six - the sixth card
     * @param seven the seventh card
     */
    public Hand (Card one, Card two, Card three, Card four, Card five, Card six, Card seven){
        cards.add(one);
        cards.add(two);
        cards.add(three);
        cards.add(four);
        cards.add(five);
        cards.add(six);
        cards.add(seven);

        this.sort();
        this.rank();
        this.value();
    }

    /**
     * creates a random hand of cardNum size
     * 
     * @param cardNum - the number of cards in the hand
     * @return - the cards
     */
    public ArrayList<Card> getRandomHand(int cardNum){
        int position;

        for(int num=0; num<cardNum; num++){

            position = (int)(Math.random()*52);

            while(this.noDuplicates(position)==false){
                position = (int)(Math.random()*52);
            }

            this.cards.add(deck[position]);
        }

        return this.cards;
    }

    /**
     * checks to see if the position was already added in the set
     * returns true if the position was added.
     *
     * @param position
     * @return
     */
    public boolean noDuplicates(int position){

        HashSet<Integer> set = new HashSet<>();


        if(set.contains(position)==false){
            set.add(position);
            return true;
        }
        return false;
    }

    /**
     * creates two random hands for texas hold'em 
     * 
     * @param hand1
     * @param hand2
     */
    public void getTwoRandomHands(ArrayList<Card> hand1, ArrayList<Card> hand2){
    	
    	ArrayList<Card> nextHand1 = new ArrayList<>();
    	for(int index=0; index<2; index++) {
    		nextHand1.add(hand1.get(index));
    	}
    	
    	ArrayList<Card> nextHand2 = hand2;
    	for(int index=0; index<2; index++) {
    		nextHand2.add(hand2.get(index));
    	}
    	        
        for(int num=0; num<cards.size(); num++){
            nextHand1.add(cards.get(num));
            nextHand2.add(cards.get(num));
        }
        
        player1 = new Hand(nextHand1.get(0), nextHand1.get(1), nextHand1.get(2), nextHand1.get(3), nextHand1.get(4), nextHand1.get(5), nextHand1.get(6));
        player2 = new Hand(nextHand2.get(0), nextHand2.get(1), nextHand2.get(2), nextHand2.get(3), nextHand2.get(4), nextHand2.get(5), nextHand2.get(6));
        
    }

    /**
     * ranks the cards in a hand
     */
    public void rank() {

        //Build the histogram of the hand.
        for(Card card : cards) {
            histogram[card.getValue()-1] += 1;
        }

        //Build the suit histogram.
        for(Card card : cards) {

            if(card.getSuit() == Constant.Suit.CLUB) {
                suitHistogram[card.getSuit().ordinal()]++;
            }
            if(card.getSuit() == Constant.Suit.DIAMOND) {
                suitHistogram[card.getSuit().ordinal()]++;
            }
            if(card.getSuit() == Constant.Suit.HEART) {
                suitHistogram[card.getSuit().ordinal()]++;
            }
            if(card.getSuit() == Constant.Suit.SPADE) {
                suitHistogram[card.getSuit().ordinal()]++;
            }

        }

        this.checkHandRank();
    }

    /**
     * checks each type of rank to see if that is in our hand
     */
    public void checkHandRank(){

        //Royal flush.
        if(histogram[9]>0 && histogram[10]>0 && histogram[11]>0 && histogram[12]>0 && histogram[13]>0
                &&
                (cards.get(0).getSuit().equals(cards.get(1).getSuit()) && cards.get(0).getSuit().equals(cards.get(2).getSuit())
                        && cards.get(0).getSuit().equals(cards.get(3).getSuit()) && cards.get(0).getSuit().equals(cards.get(4).getSuit()))
                &&
                cards.size() == 5) {

            rank = Constant.Ranks.ROYAL_FLUSH;
            return;

        }

        //Royal flush for seven card hands.
        if(((histogram[9]>0 && histogram[10]>0 && histogram[11]>0 && histogram[12]>0 && histogram[13]>0)
                && cards.size() == 7)
                &&
                (((cards.get(0).getSuit().equals(cards.get(1).getSuit()) && cards.get(0).getSuit().equals(cards.get(2).getSuit())
                        && cards.get(0).getSuit().equals(cards.get(3).getSuit()) && cards.get(0).getSuit().equals(cards.get(4).getSuit()))
                        ||
                        (cards.get(2).getSuit().equals(cards.get(3).getSuit()) && cards.get(2).getSuit().equals(cards.get(4).getSuit())
                                && cards.get(2).getSuit().equals(cards.get(5).getSuit()) && cards.get(2).getSuit().equals(cards.get(6).getSuit())))
                        ||
                        (cards.get(1).getSuit().equals(cards.get(2).getSuit()) && cards.get(1).getSuit().equals(cards.get(3).getSuit())
                                && cards.get(1).getSuit().equals(cards.get(4).getSuit()) && cards.get(1).getSuit().equals(cards.get(5).getSuit())))) {

            rank = Constant.Ranks.ROYAL_FLUSH;

        }


        //Straight flush.
        else if(longestStraight() >= 5 ) {

            suitSort();

            //If the straight flush is the first five cards:
            if(cards.get(0).getSuit().equals(cards.get(1).getSuit()) && cards.get(0).getSuit().equals(cards.get(2).getSuit())
                    && cards.get(0).getSuit().equals(cards.get(3).getSuit()) && cards.get(0).getSuit().equals(cards.get(4).getSuit())) {
                rank = Constant.Ranks.STRAIGHT_FLUSH;
            }

            //If the straight flush is in a seven card hand, check to see if it is at the end of the hand:
            else if(cards.size() == 7) {
                if((cards.get(2).getSuit().equals(cards.get(3).getSuit()) && cards.get(2).getSuit().equals(cards.get(4).getSuit())
                        && cards.get(2).getSuit().equals(cards.get(5).getSuit()) && cards.get(2).getSuit().equals(cards.get(6).getSuit()))
                        &&
                        (((cards.get(2).getValue() == (cards.get(3).getValue()-1) && cards.get(3).getValue() == (cards.get(4).getValue()-1)
                                && cards.get(4).getValue() == (cards.get(5).getValue()-1) && cards.get(5).getValue() == (cards.get(6).getValue()-1))))) {

                    rank = Constant.Ranks.STRAIGHT_FLUSH;
                }

                else if((cards.get(1).getSuit().equals(cards.get(2).getSuit()) && cards.get(1).getSuit().equals(cards.get(3).getSuit())
                        && cards.get(1).getSuit().equals(cards.get(4).getSuit()) && cards.get(1).getSuit().equals(cards.get(5).getSuit()))
                        &&
                        ((cards.get(1).getValue() == (cards.get(2).getValue()-1) && cards.get(2).getValue() == (cards.get(3).getValue()-1)
                                && cards.get(3).getValue() == (cards.get(4).getValue()-1) && cards.get(4).getValue() == (cards.get(5).getValue()-1)))) {

                    rank = Constant.Ranks.STRAIGHT_FLUSH;
                }

                else {

                    if(suitHistogram[0] >= 5 || suitHistogram[1] >= 5 || suitHistogram[2] >= 5 || suitHistogram[3] >= 5) {
                        rank = Constant.Ranks.FLUSH;
                    }

                    else {
                        rank = Constant.Ranks.STRAIGHT;
                    }
                }
            }

            else {
                rank = Constant.Ranks.STRAIGHT;
            }

        }

        //Four of a kind.
        else if(largestGroup() == 4) {
            rank = Constant.Ranks.FOUR_OF_A_KIND;
        }

        //Full house.
        else if(largestGroup() == 3) {

            boolean hasThreePair = false;
            boolean hasTwoPair = false;

            //Check if there is a 3 pair and a 2 pair.
            for(int index=0; index<histogram.length; index++) {
                if(histogram[index] == 3) {
                    hasThreePair = true;
                }
                if(histogram[index] == 2) {
                    hasTwoPair = true;
                }
            }

            if(hasTwoPair && hasThreePair) {
                rank = Constant.Ranks.FULL_HOUSE;
            }

            //Otherwise, it is a three of a kind.
            else {
                rank = Constant.Ranks.THREE_OF_A_KIND;
            }
        }

        //Flush.
        else if(suitHistogram[0] >= 5 || suitHistogram[1] >= 5 || suitHistogram[2] >= 5 || suitHistogram[3] >= 5) {
            rank = Constant.Ranks.FLUSH;
        }

        //Two pair AND one pair.
        else if(largestGroup() == 2) {

            int numberOfPairs = 0;

            for(int index=0; index<histogram.length; index++) {
                if(histogram[index] == 2) {
                    numberOfPairs++;
                }
            }

            //For two pairs:
            if(numberOfPairs >= 2) {
                rank = Constant.Ranks.TWO_PAIRS;
            }

            //For one pairs:
            else if(numberOfPairs == 1) {
                rank = Constant.Ranks.SINGLE_PAIR;
            }
        }

        //Otherwise, it is a high-card hand.
        else {
            rank = Constant.Ranks.HIGH_CARD_ONLY;
        }
    }

    /**
     * finds the longest straight in a hand
     * @return - how long the straight is
     */
    public int longestStraight() {

        int longestStraight = 0;
        int tempLength = 0;

        for(int index=0; index<histogram.length-1; index++) {

            if(histogram[index] > 0 && histogram[index+1] > 0) {
                tempLength++;
                if(tempLength > longestStraight) {
                    longestStraight = tempLength;
                }
            }

            else {
                tempLength = 0;
            }

        }
        return longestStraight + 1;
    }

    /**
     * finds the largest group in the histogram
     * @return - the value of the largest group
     */
    public int largestGroup() {

        int largestGroup = 0;

        for(int index=0; index<histogram.length; index++) {
            if(histogram[index] > largestGroup) {
                largestGroup = histogram[index];
            }
        }

        return largestGroup;
    }

    /**
     * finds the value for each type of hand with a certain rank
     */
    public void value(){

        //For royal flush 7-card tiebreakers.
        if(cards.size() == 7 && rank == Constant.Ranks.ROYAL_FLUSH) {

            //If the high cards is also the high card, that is its value.
            if(histogram[13] > 1) {
                value = 14;
            }
            else if(histogram[12] > 1) {
                value = 13;
            }
            else if(histogram[11] > 1) {
                value = 12;
            }
            else if(histogram[10] > 1) {
                value = 11;
            }

            else {
                for(int index=9; index>=0; index--) {
                    if(histogram[index] == 1) {
                        value = index+1;
                        break;
                    }
                }
            }
        }

        //For a straight flush.
        else if(rank == Constant.Ranks.STRAIGHT_FLUSH) {

            //For five card hands:
            if(cards.size() == 5) {
                value = cards.get(4).getValue();
            }

            //For seven card hands:
            else {
                for(int index=6; index>0; index--) {

                    /*Start at the end and compare to the next card; if the next card is one less
                    and of the same suit, check the NEXT card; if this is also the case, then you
                    have found the END of your straight, and this is your hand's value.
                     */
                    if(cards.get(index).getValue() == (cards.get(index-1).getValue()-1)
                            && cards.get(index).getSuit().equals(cards.get(index-1).getSuit())) {
                        if(cards.get(index-1).getValue() == (cards.get(index-2).getValue()-1)
                                && cards.get(index-1).getSuit().equals(cards.get(index-2).getSuit())) {
                            value = cards.get(index).getValue();
                        }
                    }
                }
            }

        }

        //For a four of a kind.
        else if(rank == Constant.Ranks.FOUR_OF_A_KIND) {

            for(int index=13; index>0; index--) {
                if(histogram[index] == 4) {
                    value = index + 1;
                }
            }
        }

        //For a full house.
        else if(rank == Constant.Ranks.FULL_HOUSE) {

            for(int index=13; index>0; index--) {
                if(histogram[index] == 3) {
                    value = index + 1;
                }
            }
        }

        //For a flush.
        else if(rank == Constant.Ranks.FLUSH) {

            //For five card hands:
            if(cards.size() == 5) {
                value = cards.get(4).getValue();
            }

            //For seven card hands:
            else {
                for(int index=6; index>=2; index--) {

                    /*Start at the end and compare to the next card; if the next card is one less
                    and of the same suit, check the NEXT card; if this is also the case, then you
                    have found the END of your straight, and this is your hand's value.
                     */
                    if(cards.get(index).getSuit().equals(cards.get(index-1).getSuit())) {
                        if(cards.get(index-1).getSuit().equals(cards.get(index-2).getSuit())) {
                            value = cards.get(index).getValue();
                            break;
                        }
                    }
                }
            }
        }

        else if(rank == Constant.Ranks.STRAIGHT) {

            //For five card hands:
            if(cards.size() == 5) {
                value = cards.get(4).getValue();
            }

            //For seven card hands:
            else {

                for(int index=6; index>=0; index--) {
                    if (cards.get(6).getValue() == (cards.get(5).getValue() + 1)
                            && cards.get(5).getValue() == (cards.get(4).getValue() + 1)) {
                        value = cards.get(index).getValue();
                    }
                }
            }
        }

        else if(rank == Constant.Ranks.THREE_OF_A_KIND) {

            for(int index=13; index>0; index--) {
                if(histogram[index] == 3) {
                    value = index + 1;
                }
            }
        }

        else if(rank == Constant.Ranks.SINGLE_PAIR || rank == Constant.Ranks.TWO_PAIRS) {

            for(int index=13; index>0; index--) {
                if(histogram[index] == 2) {
                    value = index + 1;
                }
            }
        }

        //For high card hands.
        else {
            value = cards.get(4).getValue();
        }

    }

    /**
     * sorts the hand by value
     */
    public void sort() {

        Card temp;
        for(int i=1; i<cards.size(); i++) {
            for (int inner = i; inner > 0; inner--) {
                if (cards.get(inner).getValue() < cards.get(inner - 1).getValue()) {
                    temp = cards.get(inner);
                    cards.set(inner, cards.get(inner-1));
                    cards.set(inner - 1,temp);
                }
            }
        }
    }

    /**
     * sorts the hand by suit
     */
    public void suitSort(){
        Card temp;
        for(int i=1; i<cards.size(); i++) {
            for (int inner = i; inner > 0; inner--) {
                if (cards.get(inner).getSuit().getMultiplier() < cards.get(inner - 1).getSuit().getMultiplier()) {
                    temp = cards.get(inner);
                    cards.set(inner, cards.get(inner-1));
                    cards.set(inner - 1,temp);
                }
            }
        }
    }

}
