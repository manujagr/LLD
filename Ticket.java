public class Ticket {
    private double ticketId;
    private ParkingSpot parkingSpot;
    public Ticket(ParkingSpot parkingSpot) {
        this.ticketId = Math.random();
        this.parkingSpot = parkingSpot;
    }

    public ParkingSpot getParkingSpot() {
        return this.parkingSpot;
    }
}
