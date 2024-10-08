import java.util.concurrent.ThreadLocalRandom;

public class FourDice extends Dice{
    private static final int min = 1;
    private static final int max = 4;
    public FourDice() {
        super(min, max);
    }

    @Override
    public int roll() {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
}
