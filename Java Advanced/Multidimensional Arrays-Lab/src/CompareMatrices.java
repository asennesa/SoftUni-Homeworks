import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CompareMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int[] firstArrayRowCol = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] firstMatrix = new int[firstArrayRowCol[0]][firstArrayRowCol[1]];
        for (int row = 0; row < firstMatrix.length; row++) {
            int[] inputRow = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int col = 0; col < firstMatrix[row].length; col++) {
                firstMatrix[row][col] = inputRow[col];
            }
        }
        int[] secondArrayRowCol = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] secondMatrix = new int[secondArrayRowCol[0]][secondArrayRowCol[1]];
        for (int row = 0; row < secondMatrix.length; row++) {
            int[] inputRow2 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
            for (int col = 0; col < secondMatrix[row].length; col++) {
                secondMatrix[row][col] = inputRow2[col];
            }
        }

        if (firstMatrix.length != secondMatrix.length) {
            System.out.println("not equal");
            return;
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            if (firstMatrix[row].length != secondMatrix[row].length) {
                System.out.println("not equal");
                return;
            }
        }
        for (int row = 0; row < firstMatrix.length; row++) {
            for (int col = 0; col < firstMatrix[row].length; col++) {
                if (firstMatrix[row][col] != secondMatrix[row][col]) {
                    System.out.println("not equal");
                    return;
                }
            }
        }
        System.out.println("equal");
    }
}
