package Vehicles;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] carSplit = reader.readLine().split("\\s+");
        Vehicle car = new Car(Double.parseDouble(carSplit[1]), Double.parseDouble(carSplit[2]));
        String[] truckSplit = reader.readLine().split("\\s+");
        Vehicle truck = new Truck(Double.parseDouble(truckSplit[1]), Double.parseDouble(truckSplit[2]));
        int n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; i++) {
            String[] currentSplit = reader.readLine().split("\\s+");
            switch (currentSplit[0]) {
                case "Drive":
                    if (currentSplit[1].equalsIgnoreCase("Car")) {
                        System.out.println(car.drive(Double.parseDouble(currentSplit[2])));
                    } else if (currentSplit[1].equalsIgnoreCase("Truck")) {
                        System.out.println(truck.drive(Double.parseDouble(currentSplit[2])));
                    }
                    break;
                case "Refuel":
                    if (currentSplit[1].equalsIgnoreCase("Car")) {
                        car.refuel(Double.parseDouble(currentSplit[2]));
                    } else if (currentSplit[1].equalsIgnoreCase("Truck")) {
                        truck.refuel(Double.parseDouble(currentSplit[2]));
                    }
                    break;
            }
        }
        System.out.println(car);
        System.out.println(truck);


    }
}
