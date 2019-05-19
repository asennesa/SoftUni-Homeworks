import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumMatrixElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rowCol = Arrays.stream(reader.readLine().split(", ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int sum = 0;
        int[][] matrix = new int[rowCol[0]][rowCol[1]];
        for (int row = 0; row < matrix.length; row++) {
            int[] input = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input[col];
                sum += matrix[row][col];

            }
        }
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        System.out.println(sum);

    }
}
