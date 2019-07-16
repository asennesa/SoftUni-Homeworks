package shapes;

public class Circle extends Shape {
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }

    @Override
    public Double calculatePerimeter() {
        Double result = 2 * Math.PI * this.radius;
        super.setPerimeter(result);
        return result;
    }

    @Override
    public Double calculateArea() {
        Double result = Math.PI * Math.pow(this.radius, 2);
        super.setArea(result);
        return result;

    }

    public final Double getRadius() {
        return radius;
    }
}
