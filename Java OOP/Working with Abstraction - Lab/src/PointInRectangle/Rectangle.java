package PointInRectangle;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public boolean contains(int X, int Y) {
        boolean isInsideX = X >= bottomLeft.getCoordinateX() && X <= topRight.getCoordinateX();
        boolean isInsideY = Y >= bottomLeft.getCoordinateY() && Y <= topRight.getCoordinateY();
        return isInsideX && isInsideY;
    }
}
