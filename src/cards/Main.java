package cards;

/**
 * Created by chloe and kylee fluckiger.
 * finds all the values from the odds class
 */
public class Main {
    /**
     * runs all the methods in odds.
     *
     * @param args
     */
    public static void main(String args[]) {

        System.out.println("Five card exhaustive timing:");
        double[] fiveCardHistogram = Odds.percentage_per_hand_category_exhaustive(5);
        for(int count=0; count<fiveCardHistogram.length; count++){
            System.out.println(fiveCardHistogram[count]);
        }

        double[] sevenCardHistogram = Odds.percentage_per_hand_category_exhaustive(7);
        System.out.println("Seven card exhaustive timing:");
        for (int count = 0; count < sevenCardHistogram.length; count++) {
            System.out.println(sevenCardHistogram[count]);
        }

        System.out.println("Five card stochastic timing");
        double [] fiveCardStochasticHistogram = Odds.percentage_per_hand_category_stochastic(5,500000);
        for (int count = 0; count < fiveCardStochasticHistogram.length; count++) {
            System.out.println(fiveCardStochasticHistogram[count]);
        }

        System.out.println("Seven card stochastic timing");
        double [] sevenCardStochasticHistogram = Odds.percentage_per_hand_category_stochastic(5,500000);
        for (int count = 0; count < sevenCardStochasticHistogram.length; count++) {
            System.out.println(sevenCardStochasticHistogram[count]);
        }

        System.out.println("Texas hold'em wining percent");

    }
}
