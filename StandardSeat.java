public class StandardSeat extends Seat {
    public StandardSeat(int row, int col) {
        super(row, col, SeatType.STANDARD);
    }

    @Override
    public int getCost() {
        return 500;
    }
}
