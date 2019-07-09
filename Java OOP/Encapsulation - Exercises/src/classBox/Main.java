package classBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Double> sides = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            sides.add(Double.parseDouble(reader.readLine()));
        }
        try {
            Box box = new Box(sides.get(0), sides.get(1), sides.get(2));
            System.out.println(box);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
