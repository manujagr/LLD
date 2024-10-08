import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager<FourWheelerParkingSpot> {
    private static final int cost = 30;

    public FourWheelerParkingSpotManager(List<FourWheelerParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    public int getCost() {
        return cost;
    }

}
