package CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private String weight;
    private String color;


    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = "n/a";
        this.color = "n/a";
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("%s:\n%s:\nPower: %s\nDisplacement: %s\nEfficiency: %s\nWeight: %s\nColor: %s"
                , model, engine.getModel(), engine.getPower(), engine.getDisplacement(), engine.getEfficiency(), getWeight(), getColor());
    }
}
