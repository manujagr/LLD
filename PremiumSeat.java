public class PremiumSeat extends Seat {
    public PremiumSeat(int row, int col) {
        super(row, col, SeatType.PREMIUM);
    }

    @Override
    public int getCost() {
        return 1000;
    }
}
