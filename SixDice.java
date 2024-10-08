import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class SixDice extends Dice{
    private static final int min = 1;
    private static final int max = 6;
    public SixDice() {
        super(min, max);
    }

    @Override
    public int roll() {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
