import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PrintDiagonalsofSquareMatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rowCol = Integer.parseInt(reader.readLine());
        String[][] matrix = new String[rowCol][rowCol];
        for (int row = 0; row < matrix.length; row++) {
            String[] eachRow = reader.readLine().split("\\s+");
            matrix[row] = eachRow;
        }

        for (int row = 0; row < matrix.length; row++) {
            System.out.print(matrix[row][row] + " ");
        }
        System.out.println();
        for (int row = matrix.length - 1; 0 <= row; row--) {
            System.out.print(matrix[row][(matrix.length - 1) - row] + " ");
        }


    }
}
