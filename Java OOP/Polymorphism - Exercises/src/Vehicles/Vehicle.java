package Vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;
    private double maxDistance;

    protected Vehicle(double fuelQuantity, double litersPerKm) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
    }

    public void refuel(double fuel) {
        this.fuelQuantity += fuel;

    }

    public String drive(double distance) {
        String output = null;
        double fuelNeeded = distance * this.litersPerKm;
        DecimalFormat df = new DecimalFormat("#.##");
        if (fuelNeeded <= fuelQuantity) {
            output = String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
            this.fuelQuantity -= distance * this.litersPerKm;
        } else {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        return output;

    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}
