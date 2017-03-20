package cards;

public class My_Best_Random_Generator implements Random_Generator {
    private long previous;
    private long multiplier, increment;

    private static final long mask =(1L<< 48)-1;

    @Override
    public int next_int(int max) {
        long value = (multiplier*previous+increment) & mask;
        previous = value;
        return (int)(value%max);
    }

    @Override
    public void set_seed(long seed) {
        previous = seed;
    }

    @Override
    public void set_constants(long const1, long const2) {
        this.multiplier = multiplier;
        this.increment = increment;
    }
}
