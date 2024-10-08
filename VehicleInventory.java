import java.util.ArrayList;
import java.util.List;

public abstract class VehicleInventory<T extends Vehicle> {
    protected List<T> vehicles;
    public VehicleInventory() {
        this.vehicles = new ArrayList<T>();
    }
    public void addVehicle(T vehicle) {
        vehicles.add(vehicle);
    }
    public void removeVehicle(T vehicle) {
        vehicles.remove(vehicle);
    }
    public T getVehicle() {
        for(T vehicle : vehicles) {
            if(vehicle.getStatus()==Status.AVAILABLE) {
                vehicle.setStatus(Status.UNAVAILABLE);
                return vehicle;
            }
        }
        return null;
    }
}
