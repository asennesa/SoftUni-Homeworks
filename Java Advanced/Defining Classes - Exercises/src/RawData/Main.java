package RawData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Car> fragile = new ArrayList<>();
        List<Car> flamable = new ArrayList<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("\\s+");
            String model = split[0];
            int engineSpeed = Integer.parseInt(split[1]);
            int enginePower = Integer.parseInt(split[2]);
            int cargoWeight = Integer.parseInt(split[3]);
            String cargoType = split[4];
            double tire1Pressure = Double.parseDouble(split[5]);
            int tire1Age = Integer.parseInt(split[6]);
            double tire2Pressure = Double.parseDouble(split[7]);
            int tire2Age = Integer.parseInt(split[8]);
            double tire3Pressure = Double.parseDouble(split[9]);
            int tire3Age = Integer.parseInt(split[10]);
            double tire4Pressure = Double.parseDouble(split[11]);
            int tire4Age = Integer.parseInt(split[12]);
            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire tire = new Tire(tire1Pressure, tire1Age, tire2Pressure, tire2Age, tire3Pressure, tire3Age, tire4Pressure, tire4Age);
            Car car = new Car(model, engine, cargo, tire);
            if (cargoType.equalsIgnoreCase("fragile")) {
                if (tire1Pressure < 1 || tire2Pressure < 1 || tire3Pressure < 1 || tire4Pressure < 1) {
                    fragile.add(car);
                }
            } else if (cargoType.equalsIgnoreCase("flamable")) {
                if (enginePower > 250) {
                    flamable.add(car);
                }
            }

        }

        String command = reader.readLine();
        if (command.equalsIgnoreCase("fragile")) {
            fragile.forEach(e -> System.out.println(e.getModel()));

        } else if (command.equalsIgnoreCase("flamable")) {
            flamable.forEach(e -> System.out.println(e.getModel()));
        }

    }
}
