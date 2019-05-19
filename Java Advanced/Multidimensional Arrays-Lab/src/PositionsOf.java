import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PositionsOf {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rowCol = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[][] Maatrix = new int[rowCol[0]][rowCol[1]];
        for (int row = 0; row < Maatrix.length; row++) {
            int[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < Maatrix[row].length; col++) {
                Maatrix[row][col] = input[col];
            }
        }
        int counter = 0;
        int numToFind = Integer.parseInt(reader.readLine());
        System.out.println();
        boolean isPresent = true;
        for (int row = 0; row < Maatrix.length; row++) {
            for (int col = 0; col < Maatrix[row].length; col++) {
                int currentElement = Maatrix[row][col];
                if (currentElement == numToFind) {
                    System.out.println(String.format("%d %d", row, col));
                    counter++;

                }

            }
        }
        if (counter == 0) {
            System.out.println("not found");
        }

    }
}
