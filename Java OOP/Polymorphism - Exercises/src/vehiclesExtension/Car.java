package vehiclesExtension;

public class Car extends Vehicle {
    private static final double AIR_CONDITIONER = 0.9;

    public Car(double fuelQuantity, double litersPerKm, double tankCapacity) {
        super(fuelQuantity, litersPerKm + AIR_CONDITIONER, tankCapacity);

    }

}
