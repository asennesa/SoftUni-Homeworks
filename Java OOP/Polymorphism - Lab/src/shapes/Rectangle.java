package shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }

    @Override
    public Double calculatePerimeter() {
        Double result = 2 * (this.height + this.width);
        super.setPerimeter(result);
        return result;
    }

    @Override
    public Double calculateArea() {
        Double result = this.height * this.width;
        super.setArea(result);
        return result;
    }
}
