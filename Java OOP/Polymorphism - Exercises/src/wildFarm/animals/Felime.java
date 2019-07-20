package wildFarm.animals;

import wildFarm.foods.Food;

public abstract class Felime extends Mammal {
    public Felime(String animalName, String animalType, double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void eat(Food food) {
        if (this.getClass().getSimpleName().equalsIgnoreCase("Cat")) {
            super.setFoodEaten(food.getQuantity());
        } else {
            if (this.getClass().getSimpleName().equalsIgnoreCase("Tiger")) {
                if (!food.getClass().getSimpleName().equalsIgnoreCase("Meat")) {
                    System.out.println(String.format("%ss are not eating that type of food!", this.getClass().getSimpleName()));
                }
            }
        }
    }
}
