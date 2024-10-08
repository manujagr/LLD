import java.util.*;
public abstract class ParkingSpotManagerFactory {
    public static ParkingSpotManager<? extends ParkingSpot> createFactory(String type, List<? extends ParkingSpot> spots){
        return switch (type.toLowerCase()) {
            case "2wheeler" -> new TwoWheelerParkingSpotManager((List<TwoWheelerParkingSpot>) spots);
            case "3wheeler" -> new ThreeWheelerParkingSpotManager((List<ThreeWheelerParkingSpot>) spots);
            case "4wheeler" -> new FourWheelerParkingSpotManager((List<FourWheelerParkingSpot>) spots);
            default -> throw new IllegalArgumentException("Invalid vehicle type: " + type);
        };
    }
}
