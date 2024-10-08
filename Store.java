import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Store {
    protected int storeID;
    protected String storeName;
    protected Location location;
    List<Reservation> reservationList;
    private CarVehicleInventory carVehicleInventory;
    private BikeVehicleInventory bikeVehicleInventory;

    public Store(int store, String storeName, Location location) {
        this.storeID = store;
        this.storeName = storeName;
        this.location = location;
        this.reservationList = new ArrayList<>();
        this.carVehicleInventory = new CarVehicleInventory();
        this.bikeVehicleInventory = new BikeVehicleInventory();
    }

    public CarVehicleInventory getCarVehicleInventory() {
        return carVehicleInventory;
    }
    public BikeVehicleInventory getBikeVehicleInventory() {
        return bikeVehicleInventory;
    }

    public Reservation createReservation(User user, Date startDate, Date endDate, Vehicle vehicle) {
        Reservation reservation = new Reservation(user, startDate, endDate, location, vehicle);
        vehicle.setStatus(Status.UNAVAILABLE);
        reservationList.add(reservation);
        System.out.println("Reservation is created for the user " + user.getName() + " for the vehicle " + vehicle.getVehicleType() + " " + vehicle.getVehicleNumber());
        return reservation;
    }

    public String completeReservation(Reservation reservation, Payment payment) {
        int cost = reservation.getVehicle().getDailyCost()*5;
        Bill bill = new Bill(reservation, cost, payment);
        payment.pay(cost);
        reservation.setPaymentStatus(PaymentStatus.COMPLETED);
        return "Payment is completed for the reservation " + reservation.getReservationID();
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int store) {
        this.storeID = store;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
