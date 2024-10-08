import java.util.*;

public class Reservation {
    private int reservationID;
    private Vehicle vehicle;
    private User user;
    private Date dateStart;
    private Date dateEnd;
    private Location location;
    private Store store;
    private ReservationStatus reservationStatus;
    private PaymentStatus paymentStatus;
    public Reservation(User user, Date dateStart, Date dateEnd, Location location, Vehicle vehicle) {
        Random random = new Random();
        this.reservationID = random.nextInt();
        this.vehicle = vehicle;
        this.user = user;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.location = location;
        this.reservationStatus = ReservationStatus.IN_PROGRESS;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
        this.reservationID = reservationID;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setStore(Store store) {
        this.store = store;
    }
}
