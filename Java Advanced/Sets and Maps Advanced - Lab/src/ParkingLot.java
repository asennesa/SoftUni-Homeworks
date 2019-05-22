import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class ParkingLot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        HashSet<String>cars = new HashSet<>();
        while(!"end".equalsIgnoreCase(input=reader.readLine())){
            String[] split = input.split(", ");
            String command = split[0];
            String carNumber = split[1];
            if(command.equalsIgnoreCase("IN")){
                cars.add(carNumber);
            }else if(command.equalsIgnoreCase("OUT")){
                cars.remove(carNumber);
            }

        }
        if(cars.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else{
            cars.stream().forEach(e-> System.out.println(e));
        }

    }
}
