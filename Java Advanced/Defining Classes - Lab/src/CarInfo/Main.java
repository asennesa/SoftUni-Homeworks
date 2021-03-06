package CarInfo;

import CarInfo.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Car> allCars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("\\s+");
            String make = split[0];
            String model = split[1];
            int horsePower = Integer.parseInt(split[2]);

            Car car = new Car();
            car.setMake(make);
            car.setModel(model);
            car.setHorsePower(horsePower);
            allCars.add(car);
        }
        allCars.forEach(e -> System.out.println(e.carInfo()));


    }
}
