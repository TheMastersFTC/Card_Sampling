package cards;

/**
 * Implementation of a generator that produces a very
 * non-random sequence of numbers.
 * @author Erin Parker
 * @date February 23, 2007
 */
public class My_Worst_Random_Generator implements Random_Generator
{

    long seed;
    long const1;
    long const2;

    /**
     * 
     * @param max the upper bound for the range of the random number,
     * non-inclusive.
     * @return the next random number
     */
    public int next_int(int max)
    {
        return 1;
    }

    /**
     * sets the value of seed
     * 
     * @param _seed - what the number step should be
     */
    public void set_seed(long _seed)
    {
        this.seed = _seed;
    }

    /**
     * sets the constants for random numbers
     * 
     * @param _const1 - first constant 
     * @param _const2 - second constant
     */
    public void set_constants(long _const1, long _const2)
    {
        this.const1 = _const1;
        this.const2 = _const2;
    }

}

