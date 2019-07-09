package pizzaCalories;

public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        Validate.topping(toppingType);
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        Validate.toppingWeightValidate(this.getToppingType(), weight);
        this.weight = weight;
    }

    public String getToppingType() {
        return toppingType;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateCalories() {
        double modifier = 0;
        switch (getToppingType()) {
            case "Meat":
                modifier = 1.2;
                break;
            case "Veggies":
                modifier = 0.8;
                break;
            case "Cheese":
                modifier = 1.1;
                break;
            case "Sauce":
                modifier = 0.9;
                break;
        }
        return (2 * this.getWeight()) * modifier;

    }
}
