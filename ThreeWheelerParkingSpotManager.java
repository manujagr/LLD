import java.util.*;
public class ThreeWheelerParkingSpotManager extends ParkingSpotManager<ThreeWheelerParkingSpot> {
    private static final int cost = 20;
    public ThreeWheelerParkingSpotManager(List<ThreeWheelerParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    public int getCost() {
        return cost;
    }
}
