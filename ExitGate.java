import java.util.List;

public class ExitGate {
    private static ExitGate instance;
    private ExitGate() {}

    public static ExitGate getInstance() {
        if (instance == null) {
            synchronized (EntranceGate.class) { // Ensure thread-safety
                if (instance == null) { // Double-checked locking
                    instance = new ExitGate();
                }
            }
        }
        return instance;
    }

    public int calculateParkingFee(PaymentMethod paymentMethod, String type, List<? extends ParkingSpot> parkingSpots, Ticket ticket) {
        ParkingSpotManager<? extends ParkingSpot> parkingSpotManager = ParkingSpotManagerFactory.createFactory(type, parkingSpots);
        payParkingFee(paymentMethod, parkingSpotManager.getCost(), ticket);
        return parkingSpotManager.getCost();
    }

    private boolean payParkingFee(PaymentMethod paymentMethod, int amount, Ticket ticket) {
        if(paymentMethod.pay(amount)){
            System.out.println("Payment method completed successfully");
            freeParkingSpot(ticket.getParkingSpot());
        }
        return true;
    }

    private void freeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpot.setStatus(Status.Free);
        System.out.println("Parking Space is free now");
    }
}
