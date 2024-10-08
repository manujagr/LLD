public abstract class Seat {
    protected int row;
    protected int number;
    protected SeatType seatType;
    public Seat(int row, int number, SeatType seatType) {
        this.row = row;
        this.number = number;
        this.seatType = seatType;
    }
    public abstract int getCost();
}
