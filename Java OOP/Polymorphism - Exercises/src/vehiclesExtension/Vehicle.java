package vehiclesExtension;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private double litersPerKm;
    private double tankCapacity;

    protected Vehicle(double fuelQuantity, double litersPerKm, double tankCapacity) {
        this.fuelQuantity = fuelQuantity;
        this.litersPerKm = litersPerKm;
        this.tankCapacity = tankCapacity;
    }

    public void refuel(double fuel) {
        if (fuel <= 0) {
            System.out.println("Fuel must be a positive number");
        } else {
            if (fuel + this.fuelQuantity > this.tankCapacity) {
                System.out.println("Cannot fit fuel in tank");
            } else {
                this.fuelQuantity += fuel;
            }
        }

    }

    public double getLitersPerKm() {
        return litersPerKm;
    }

    public double getTankCapacity() {
        return tankCapacity;
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

    public String driveFull(double distance) {
        String output = null;
        double ON = this.litersPerKm + 1.4;
        double fuelNeeded = distance * ON;
        DecimalFormat df = new DecimalFormat("#.##");
        if (fuelNeeded <= this.fuelQuantity) {
            output = String.format("%s travelled %s km", this.getClass().getSimpleName(), df.format(distance));
            this.fuelQuantity -= fuelNeeded;
        } else {
            output = String.format("%s needs refueling", this.getClass().getSimpleName());
        }
        return output;
    }

    public void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(), getFuelQuantity());
    }
}
