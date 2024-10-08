public class SeatFactory {
    public static Seat createSeat(int row, int number, SeatType seatType) {
        return switch (seatType) {
            case STANDARD -> new StandardSeat(row, number);
            case PREMIUM -> new PremiumSeat(row, number);
            default -> throw new IllegalArgumentException("Invalid seat type");
        };
    }
}
