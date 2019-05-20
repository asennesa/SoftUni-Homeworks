import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DiagonalDifference {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[][]matrix = new String[n][n];
        for (int row = 0; row < n; row++) {
            String[]eachRow = reader.readLine().split("\\s+");
            matrix[row]=eachRow;
        }
        int sumTopLeftDiagonal = 0;
        int sumToprightDiagonal = 0;
        for (int row = 0; row < matrix.length; row++) {
            sumTopLeftDiagonal+=Integer.valueOf(matrix[row][row]);
            sumToprightDiagonal+=Integer.valueOf(matrix[row][matrix[row].length-1-row]);
        }
        int finalsum  = Math.abs(sumTopLeftDiagonal-sumToprightDiagonal);
        System.out.println(finalsum);
    }

}
