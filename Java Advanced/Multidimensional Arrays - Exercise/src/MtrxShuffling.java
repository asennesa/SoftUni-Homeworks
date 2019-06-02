import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MtrxShuffling {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] dimension = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[dimension[0]][dimension[1]];
        for (int i = 0; i < matrix.length; i++) {
            String[] row = reader.readLine().split("\\s+");
            matrix[i] = row;
        }
        String input = "";
        while (!"END".equalsIgnoreCase(input = reader.readLine())) {
            String[] currentCommand = input.split("\\s+");
            if (!currentCommand[0].equalsIgnoreCase("swap")) {
                System.out.println("Invalid input!");
                continue;
            }
            if (currentCommand.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }
            int firstRow = Integer.parseInt(currentCommand[1]);
            int firstCol = Integer.parseInt(currentCommand[2]);
            int secondRow = Integer.parseInt(currentCommand[3]);
            int secondCol = Integer.parseInt(currentCommand[4]);

            if (!currentCommand[0].equalsIgnoreCase("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            if (inBounds(firstRow, firstCol, matrix) && inBounds(secondRow, secondCol, matrix)) {
                System.out.println("Invalid input!");

            } else {
                String temp = matrix[firstRow][firstCol];
                matrix[firstRow][firstCol] = matrix[secondRow][secondCol];
                matrix[secondRow][secondCol] = temp;
                printMatrix(matrix);
            }

        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static boolean inBounds(int row, int col, String[][] matrix) {
        return row < 0 || row > matrix.length || col < 0 || col > matrix[row].length;
    }
}
