package CarSalesman;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Engine> engineMap = new HashMap<>();

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] split = reader.readLine().split("\\s+");
            if (split.length == 4) {
                Engine engine = new Engine(split[0], split[1]);
                engine.setDisplacement(split[2]);
                engine.setEfficiency(split[3]);
                if (!engineMap.containsKey(split[0])) {
                    engineMap.put(split[0], engine);
                }
            }
            if (split.length == 3) {
                Engine engine = new Engine(split[0], split[1]);
                if (Character.isDigit(split[2].charAt(0))) {
                    engine.setDisplacement(split[2]);
                } else {
                    engine.setEfficiency(split[2]);
                }
                if (!engineMap.containsKey(split[0])) {
                    engineMap.put(split[0], engine);
                }
            } else if (split.length == 2) {
                Engine engine = new Engine(split[0], split[1]);
                if (!engineMap.containsKey(split[0])) {
                    engineMap.put(split[0], engine);
                }
            }
        }
        int m = Integer.parseInt(reader.readLine());
        LinkedList<Car> cars = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            String[] split = reader.readLine().split("\\s+");
            String model = split[0];
            String engine = split[1];
            if (split.length == 4) {
                Car car = new Car(model, engineMap.get(engine));
                car.setColor(split[3]);
                car.setWeight(split[2]);
                cars.add(car);
            }
            if (split.length == 3) {
                Car car = new Car(model, engineMap.get(engine));
                if (Character.isDigit(split[2].charAt(0))) {
                    car.setWeight(split[2]);
                } else {
                    car.setColor(split[2]);
                }
                cars.add(car);
            }
            if (split.length == 2) {
                Car car = new Car(model, engineMap.get(engine));
                cars.add(car);
            }

        }
        cars.forEach(car -> System.out.println(car));

    }
}
