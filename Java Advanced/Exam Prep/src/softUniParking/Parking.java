package softUniParking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.cars = new LinkedHashMap<>();
        this.capacity = capacity;
    }

    public String addCar(Car car) {
        String message;
        if (cars.containsKey(car.getRegistrationNumber())) {
            message = "Car with that registration number, already exists!";
        } else if (cars.size() >= this.capacity) {
            message = "Parking is full!";
        } else {
            cars.put(car.getRegistrationNumber(), car);
            message = String.format("Successfully added new car %s %s", car.getMake(), car.getRegistrationNumber());
        }
        return message;

    }

    public String removeCar(String registrationNumber) {
        String message;
        if (!cars.containsKey(registrationNumber)) {
            message = "Car with that registration number, doesn't exists!";
        } else {
            cars.remove(registrationNumber);
            message = String.format("Successfully removed %s", registrationNumber);
        }
        return message;
    }

    public Car getCar(String registrationNumber) {
        Car car = null;
        for (Map.Entry<String, Car> carEntry : cars.entrySet()) {
            if (carEntry.getValue().getRegistrationNumber().equalsIgnoreCase(registrationNumber)) {
                car = carEntry.getValue();

            }
        }
        return car;
    }
    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String registrationNumber : registrationNumbers) {
                System.out.println(removeCar(registrationNumber));

        }
    }
    public int getCount(){
        return cars.size();
    }
}
