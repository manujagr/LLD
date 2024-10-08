import java.util.*;
public class EntranceGate {

    private static EntranceGate instance;
    private EntranceGate() {}

    public static EntranceGate getInstance() {
        if (instance == null) {
            synchronized (EntranceGate.class) { // Ensure thread-safety
                if (instance == null) { // Double-checked locking
                    instance = new EntranceGate();
                }
            }
        }
        return instance;
    }

    public ParkingSpot findParkingSpot(String type,  List<? extends ParkingSpot> parkingSpots) {
        ParkingSpotManager<? extends ParkingSpot> manager = ParkingSpotManagerFactory.createFactory(type, parkingSpots);
        ParkingSpot parkingSpot = manager.getParkingSpot();
        return parkingSpot;
    }

    public String bookParkingSpot(ParkingSpot parkingSpot) {
        if(parkingSpot == null) {
            System.out.println("ParkingSpot is not available");
            return "Not Available at this time";
        } else {
            parkingSpot.setStatus(Status.Occupied);
            printTicket(parkingSpot);
        }
        printTicket(parkingSpot);
        return "Your parking spot is " + parkingSpot.getId();
    }
    private void printTicket(ParkingSpot parkingSpot) {
        Ticket ticket = new Ticket(parkingSpot);
    }
}
