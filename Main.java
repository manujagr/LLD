import java.awt.dnd.DropTarget;
import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to the Best Car Rental Service in India!");
        User user = new User(1, "Manuj");

        BikeVehicle bikeVehicle1 = new BikeVehicle(1, "RJ14 2200", VehicleType.BIKE, Status.AVAILABLE);
        CarVehicle carVehicle1 = new CarVehicle(2, "RJ14 2211", VehicleType.CAR, Status.AVAILABLE);
        BikeVehicle bikeVehicle2 = new BikeVehicle(2, "RJ14 2212", VehicleType.BIKE, Status.AVAILABLE);
        CarVehicle carVehicle2 = new CarVehicle(3, "RJ14 2213", VehicleType.CAR, Status.AVAILABLE);

        Location location1 = new Location(2, "Jaipur");
        Location location2 = new Location(3, "Mumbai");

        StoreManager storeManager = StoreManager.getInstance();
        Store store1 = new Store(123, "Jaipur Car Rental Store", location1);
        Store store2 = new Store(123, "Mumbai Car Rental Store", location2);
        storeManager.addStore(store1);
        storeManager.addStore(store2);

        store1.getBikeVehicleInventory().addVehicle(bikeVehicle1);
        store1.getCarVehicleInventory().addVehicle(carVehicle1);
        store2.getBikeVehicleInventory().addVehicle(bikeVehicle2);
        store2.getCarVehicleInventory().addVehicle(carVehicle2);

        Store store = storeManager.getStorebyLocation(location1);
        BikeVehicle bikeVehicle = store.getBikeVehicleInventory().getVehicle();
        Reservation reservation = store.createReservation(user, new Date(), new Date(), bikeVehicle);
        store.completeReservation(reservation, new CashPayment());
    }
}