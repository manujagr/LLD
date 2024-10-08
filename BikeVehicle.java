public class BikeVehicle extends Vehicle {
    private PricingStrategy pricingStrategy;
    public BikeVehicle(int vehicleID, String vehicleNumber, VehicleType vehicleType, Status status){
        super(vehicleID, vehicleNumber, vehicleType, status);
        this.pricingStrategy = new BikePricingStrategy();
        super.setDailyCost(pricingStrategy.calculatePrice());
    }
}
