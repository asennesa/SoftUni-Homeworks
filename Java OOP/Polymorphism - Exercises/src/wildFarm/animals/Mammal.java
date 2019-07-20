package wildFarm.animals;

import wildFarm.foods.Food;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {
    private String livingRegion;

    public Mammal(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void eat(Food food) {
        if (this.getClass().getSimpleName().equalsIgnoreCase("Mouse")) {
            if (!food.getClass().getSimpleName().equalsIgnoreCase("Vegetable")) {
                System.out.println("Mice are not eating that type of food!");
            } else {
                super.eat(food);
            }
        } else {
            if (!food.getClass().getSimpleName().equalsIgnoreCase("Vegetable")) {
                System.out.println(String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
            } else {
                super.eat(food);
            }
        }
    }

    public String getLivingRegion() {
        return this.livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return String.format("%s[%s, %s, %s, %d]", this.getAnimalType(), this.getAnimalName()
                , df.format(this.getAnimalWeight()), this.getLivingRegion(), this.getFoodEaten());
    }
}
