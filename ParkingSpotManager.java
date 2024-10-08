import java.util.*;

public abstract class ParkingSpotManager<T extends ParkingSpot> {
    List<T> parkingSpots;
    public ParkingSpotManager(List<T> list) {
        this.parkingSpots = list;
    }
    public List<T> getParkingSpots() {
        return parkingSpots;
    }
    public void addParkingSpot(T parkingSpot) {
        parkingSpots.add(parkingSpot);
    }
    public void removeParkingSpot(T parkingSpot) {
        parkingSpots.remove(parkingSpot);
    }

    public void updateParkingSpotStatus(T parkingSpot, Status status) {
        parkingSpot.setStatus(status);
    }
    public T getParkingSpot() {
        for (T spot : parkingSpots) {
            if(spot.getStatus() == Status.Free)
                return spot;
        }
        return null;
    }
    public void bookParkingSpot(T parkingSpot) {
        parkingSpot.setStatus(Status.Occupied);
    }
    public void freeParkingSpot(T parkingSpot) {
        parkingSpot.setStatus(Status.Free);
    }

    public abstract int getCost();
}