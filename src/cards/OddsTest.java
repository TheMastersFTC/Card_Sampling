package cards;
import org.junit.Test;
import java.util.ArrayList;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by chloe on 3/20/2017.
 */
public class OddsTest {

    @Test
    public void percentageExhaustiveTest(){
        
    	double [] histogram = Odds.percentage_per_hand_category_exhaustive(5);
    	for(double bin : histogram) {
    		System.out.println(bin);
    	}
    }
    
}