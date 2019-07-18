package vehiclesExtension;

public class Truck extends Vehicle {
    private static final double AIR_CONDITIONER = 1.6;

    public Truck(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER, tankCapacity);
    }


    @Override
    public void refuel(double fuel) {
        super.refuel(fuel * 0.95);
    }
}
