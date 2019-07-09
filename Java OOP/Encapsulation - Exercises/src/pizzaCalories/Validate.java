package pizzaCalories;

public class Validate {
    public static void flour(String flourType) {
        if (!flourType.equalsIgnoreCase("white") && !flourType.equalsIgnoreCase("wholegrain")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    public static void technique(String technique) {
        if (!technique.equalsIgnoreCase("Crispy") && !technique.equalsIgnoreCase("Chewy") &&
                !technique.equalsIgnoreCase("Homemade")) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }

    }

    public static void topping(String topping) {
        if (!topping.equalsIgnoreCase("meat") && !topping.equalsIgnoreCase("Veggies") &&
                !topping.equalsIgnoreCase("Cheese") && !topping.equalsIgnoreCase("Sauce")) {
            throw new IllegalArgumentException("Cannot place " + topping + " on top of your pizza.");
        }
    }

    public static void doughtWeightValdate(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
    }

    public static void toppingWeightValidate(String toppingname, double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(toppingname + " weight should be in the range [1..50].");
        }
    }

    public static void pizzaNameValidate(String name) {
        if (name.trim().isEmpty() || name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
    }

    public static void toppingsNumber(int number) {
        if (number < 0 || number > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }
}
