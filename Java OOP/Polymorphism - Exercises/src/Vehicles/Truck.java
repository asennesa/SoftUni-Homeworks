package Vehicles;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER);
    }


    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }
}
