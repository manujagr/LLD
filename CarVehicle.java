public class CarVehicle extends Vehicle {
    private PricingStrategy pricingStrategy;
    public CarVehicle(int vehicleID, String vehicleNumber, VehicleType vehicleType, Status status) {
        super(vehicleID, vehicleNumber, vehicleType, status);
        this.pricingStrategy = new CarPricingStrategy();
        super.setDailyCost(pricingStrategy.calculatePrice());
    }
}
