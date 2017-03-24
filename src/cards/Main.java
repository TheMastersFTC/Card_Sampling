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
    	
//        System.out.println("Five card exhaustive timing:");
//        double[] fiveCardHistogram = Odds.percentage_per_hand_category_exhaustive(5);
//        for(int count=0; count<fiveCardHistogram.length; count++){
//            System.out.println(fiveCardHistogram[count]);
//        }
//        
//        System.out.println(System.nanoTime() - startTime);

//        double[] sevenCardHistogram = Odds.percentage_per_hand_category_exhaustive(7);
//        System.out.println("Seven card exhaustive timing:");
//        for (int count = 0; count < sevenCardHistogram.length; count++) {
//            System.out.println(sevenCardHistogram[count]);
//        }
//
//        System.out.println("Five card stochastic timing");
//        double [] fiveCardStochasticHistogram = Odds.percentage_per_hand_category_stochastic(5,500000);
//        for (int count = 0; count < fiveCardStochasticHistogram.length; count++) {
//            System.out.println(fiveCardStochasticHistogram[count]);
//        }
//
//        System.out.println("Seven card stochastic timing");
//        double [] sevenCardStochasticHistogram = Odds.percentage_per_hand_category_stochastic(5,500000);
//        for (int count = 0; count < sevenCardStochasticHistogram.length; count++) {
//            System.out.println(sevenCardStochasticHistogram[count]);
//        }
//        
        
        //COMPUTE STOCHASTIC SAMPLE
    	long totalTime = 0;
    	long elapsedTime = 0;
    	
        //Time to compute stochastic sample; average of 50 runs.
        for(int sampleSize=10_000; sampleSize<=10_000_000; sampleSize += 500_000) {
        	
        	totalTime = 0;
        	        	
        	//For each run.
        	for(int counter=0; counter<50; counter++) {
        		long startTime = System.nanoTime();
        		Odds.percentage_per_hand_category_stochastic(7, sampleSize);
        		elapsedTime = System.nanoTime() - startTime;
            	totalTime += elapsedTime;
        	}
        	
        	System.out.println("Average time for " + sampleSize + " is " + totalTime/50);
        	
        }

        System.out.println("Texas hold'em wining percent");
//
    }
}
