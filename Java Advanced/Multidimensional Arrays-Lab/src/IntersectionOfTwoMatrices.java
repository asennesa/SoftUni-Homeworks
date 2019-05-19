import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int rows = Integer.parseInt(reader.readLine());
        int cols = Integer.parseInt(reader.readLine());

        char[][] matrixA = new char[rows][cols];
        char[][] matrixB = new char[rows][cols];
        char[][] matrixC = new char[rows][cols];

        for (int row = 0; row < rows * 2; row++) {
            String[] elements = reader.readLine().split("\\s+");
            for (int col = 0; col < elements.length; col++) {
                if (row < rows) {
                    matrixA[row][col] = elements[col].charAt(0);
                } else {
                    matrixB[row - rows][col] = elements[col].charAt(0);
                }
            }

        }
        for (int row = 0; row < matrixA.length; row++) {
            for (int col = 0; col < matrixA[row].length; col++) {
                if (matrixA[row][col] == matrixB[row][col]) {
                    matrixC[row][col] = matrixA[row][col];
                } else {
                    matrixC[row][col] = '*';
                }

            }
        }
        for (int row = 0; row < matrixC.length; row++) {
            for (int col = 0; col < matrixC[row].length; col++) {
                System.out.print(matrixC[row][col] + " ");
            }
            System.out.println();
        }

    }
}
