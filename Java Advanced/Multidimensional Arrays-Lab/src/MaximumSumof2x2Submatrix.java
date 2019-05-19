import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaximumSumof2x2Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rowCol = Arrays.stream(reader.readLine().split(", ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[][] matrix = new int[rowCol[0]][rowCol[1]];
        int[][] twoByTwoMatrix = new int[2][2];

        for (int mRow = 0; mRow < matrix.length; mRow++) {
            int[] input = Arrays.stream(reader.readLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int mCol = 0; mCol < matrix[mRow].length; mCol++) {
                matrix[mRow][mCol] = input[mCol];

            }
        }

        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sumTest = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sumTest > bestSum) {
                    bestSum = sumTest;
                    resultRow = row;
                    resultCol = col;
                }

            }

        }
        System.out.println(matrix[resultRow][resultCol] + " " + matrix[resultRow][resultCol + 1]);
        System.out.println(matrix[resultRow + 1][resultCol] + " " + matrix[resultRow + 1][resultCol + 1]);
        System.out.println(bestSum);
    }
}

