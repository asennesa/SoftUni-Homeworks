package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Validate.flour(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validate.technique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Validate.doughtWeightValdate(weight);
        this.weight = weight;
    }

    public String getFlourType() {
        return flourType;
    }

    public String getBakingTechnique() {
        return bakingTechnique;
    }

    public double getWeight() {
        return weight;
    }

    public double calculateCalories() {
        double technique = 0;
        double flouTypeValue = 0;
        switch (getFlourType()) {
            case "White":
                flouTypeValue = 1.5;
                break;
            case "Wholegrain":
                flouTypeValue = 1.0;
                break;
        }
        switch (getBakingTechnique()) {
            case "Crispy":
                technique = 0.9;
                break;
            case "Chewy":
                technique = 1.1;
                break;
            case "Homemade":
                technique = 1.0;
                break;

        }
        return (2 * getWeight() * technique * flouTypeValue);

    }
}
