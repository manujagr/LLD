public abstract class ParkingSpot {
    private int id;
    private VehicleType vehicleType;
    private Status status;

    public ParkingSpot(int id, VehicleType vehicleType, Status status) {
        this.id = id;
        this.vehicleType = vehicleType;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public VehicleType getVehicleType() {
        return vehicleType;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
