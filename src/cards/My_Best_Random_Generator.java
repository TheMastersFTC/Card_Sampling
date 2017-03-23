package cards;

/**
 * created by Chloe Josien and Kylee Fluckiger
 * picks random numbers
 */
public class My_Best_Random_Generator implements Random_Generator {
    private long previous;
    private long multiplier, increment;

    private static final long mask =(1L<< 48)-1;

    /**
     * finds the next int
     * 
     * @param max the upper bound for the range of the random number,
     * non-inclusive.
     * @return
     */
    @Override
    public int next_int(int max) {
        long value = (multiplier*previous+increment) & mask;
        previous = value;
        return (int)(value%max);
    }

    /**
     * sets the previous value
     * @param seed the seed parameter used to initialize the
     */
    @Override
    public void set_seed(long seed) {
        previous = seed;
    }

    /**
     * sets the constants values.
     * 
     * @param const1
     * @param const2
     */
    @Override
    public void set_constants(long const1, long const2) {
        this.multiplier = multiplier;
        this.increment = increment;
    }
}
