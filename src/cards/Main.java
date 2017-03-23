package cards;

/**
 * Created by chloe and kylee fluckiger.
 * finds all the values from the odds class
 */
public class Main {
    /**
     * runs all the methods in odds.
     * @param args
     */
    public static void main(String args[]){

//        double[] fiveCardHistogram = Odds.percentage_per_hand_category_exhaustive(5);
//        for(int count=0; count<fiveCardHistogram.length; count++){
//            System.out.println(fiveCardHistogram[count]*100);
//        }

        double[] sevenCardHistogram = Odds.percentage_per_hand_category_exhaustive(7);
        for(int count=0; count<sevenCardHistogram.length; count++){
            System.out.println(sevenCardHistogram[count]*100);
        }

    }
}
