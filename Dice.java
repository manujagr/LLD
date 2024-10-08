public abstract class Dice {
    int min;
    int max;

    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public abstract int roll();
}
