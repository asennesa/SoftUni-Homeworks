package wildFarm;

import wildFarm.animals.*;
import wildFarm.foods.Food;
import wildFarm.foods.Meat;
import wildFarm.foods.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Animal> animals = new ArrayList<>();
        String loop = reader.readLine();
        while (true) {
            String[] split = loop.split("\\s+");
            String type = split[0];
            String name = split[1];
            double weight = Double.parseDouble(split[2]);
            String livingRegion = split[3];
            String[] foodSplit = reader.readLine().split("\\s+");
            String foodName = foodSplit[0];
            int foodQuant = Integer.parseInt(foodSplit[1]);
            Animal animal = null;
            Food food = null;
            if (type.equalsIgnoreCase("Cat")) {
                animal = new Cat(name, type, weight, livingRegion, split[4]);

            } else if (type.equalsIgnoreCase("Tiger")) {
                animal = new Tiger(name, type, weight, livingRegion);
            } else if (type.equalsIgnoreCase("Zebra")) {
                animal = new Zebra(name, type, weight, livingRegion);
            } else if (type.equalsIgnoreCase("Mouse")) {
                animal = new Mouse(name, type, weight, livingRegion);
            }
            if (foodName.equalsIgnoreCase("Meat")) {
                food = new Meat(foodQuant);
            } else if (foodName.equalsIgnoreCase("Vegetable")) {
                food = new Vegetable(foodQuant);
            }
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
            loop = reader.readLine();
            if (loop.equalsIgnoreCase("End")) {
                break;
            }
        }
        animals.forEach(e -> System.out.println(e.toString()));

    }
}
