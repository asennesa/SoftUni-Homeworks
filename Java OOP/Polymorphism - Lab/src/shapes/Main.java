package shapes;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Circle(10.0);
        shape.calculateArea();
        shape.calculatePerimeter();
        System.out.println(shape.getArea());
        System.out.println(shape.getPerimeter());

        Shape shape1 = new Rectangle(10.0, 10.0);
        shape1.calculateArea();
        shape1.calculatePerimeter();
        System.out.println(shape1.getArea());
        System.out.println(shape1.getPerimeter());


    }
}
