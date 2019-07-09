package pizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;
    private int numberOfToppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        this.setToppings(numberOfToppings);
        this.dough = null;
        toppings = new ArrayList<>(this.numberOfToppings);
    }

    private void setName(String name) {
        Validate.pizzaNameValidate(name);
        this.name = name;
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    private void setToppings(int numberOfToppings) {
        Validate.toppingsNumber(numberOfToppings);
        this.numberOfToppings = numberOfToppings;
    }

    public String getName() {
        return name;
    }

    public void addTopping(Topping topping) {
        this.toppings.add(topping);

    }

    public double getOverallCalories() {
        return this.dough.calculateCalories() +
                this.toppings.stream()
                        .mapToDouble(Topping::calculateCalories)
                        .sum();

    }
}
