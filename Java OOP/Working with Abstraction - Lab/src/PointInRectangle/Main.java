package PointInRectangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] split = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int bottomLeftX = split[0];
        int bottomLeftY = split[1];
        int topRightX = split[2];
        int topRightY = split[3];
        Point bottomLeft = new Point(bottomLeftX, bottomLeftY);
        Point topRight = new Point(topRightX, topRightY);
        Rectangle rectangle = new Rectangle(bottomLeft, topRight);
        int nummberOfTests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < nummberOfTests; i++) {
            int[] currentTestCoordinates = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int X = currentTestCoordinates[0];
            int Y = currentTestCoordinates[1];
            System.out.println(rectangle.contains(X, Y));

        }
    }
}
