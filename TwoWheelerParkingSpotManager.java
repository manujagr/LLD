import java.util.*;
public class TwoWheelerParkingSpotManager extends ParkingSpotManager<TwoWheelerParkingSpot> {
    private static final int cost = 10;
    public TwoWheelerParkingSpotManager(List<TwoWheelerParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    public int getCost() {
        return cost;
    }
}
