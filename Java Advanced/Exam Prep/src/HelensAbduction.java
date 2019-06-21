import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelensAbduction {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int energy = Integer.parseInt(reader.readLine());
        int spartaSize = Integer.parseInt(reader.readLine());
        char[][] matrix = new char[spartaSize][spartaSize];
        int helenRow = 0;
        int helenCol = 0;
        int parisRow = 0;
        int parisCol = 0;

        for (int i = 0; i < spartaSize; i++) {
            String line = reader.readLine();
            if (line.contains("H")) {
                helenCol = line.indexOf("H");
                helenRow = i;
            } else if (line.contains("P")) {
                parisCol = line.indexOf("P");
                parisRow = i;
            }
            matrix[i] = line.toCharArray();
        }

        boolean foundHelen = false;
        boolean parisDead = false;
        while (true) {
            if (foundHelen) {
                break;
            }
            if (parisDead) {
                break;
            }
            String[] split = reader.readLine().split("\\s+");
            String command = split[0];
            int enemyRow = Integer.parseInt(split[1]);
            int enemyCol = Integer.parseInt(split[2]);

            switch (command) {

                case "up":
                    matrix[enemyRow][enemyCol] = 'S';
                    if (!isInBounds(matrix, parisRow - 1, parisCol)) {
                        energy--;
                    } else if (matrix[parisRow - 1][parisCol] == '-') {
                        matrix[parisRow - 1][parisCol] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisRow = parisRow - 1;
                        energy--;
                    } else if (matrix[parisRow - 1][parisCol] == 'S') {
                        matrix[parisRow - 1][parisCol] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisRow = parisRow - 1;
                        energy--;
                        energy -= 2;

                    } else if (matrix[parisRow - 1][parisCol] == 'H') {
                        matrix[parisRow - 1][parisCol] = '-';
                        matrix[parisRow][parisCol] = '-';
                        parisRow = parisRow - 1;
                        energy--;
                        foundHelen = true;


                    }
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        parisDead = true;
                    }
                    break;
                case "down":
                    matrix[enemyRow][enemyCol] = 'S';
                    if (!isInBounds(matrix, parisRow + 1, parisCol)) {
                        energy--;
                    } else if (matrix[parisRow + 1][parisCol] == '-') {
                        matrix[parisRow + 1][parisCol] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisRow = parisRow + 1;
                        energy--;
                    } else if (matrix[parisRow + 1][parisCol] == 'S') {
                        matrix[parisRow + 1][parisCol] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisRow = parisRow + 1;
                        energy--;
                        energy -= 2;

                    } else if (matrix[parisRow + 1][parisCol] == 'H') {
                        matrix[parisRow + 1][parisCol] = '-';
                        matrix[parisRow][parisCol] = '-';
                        parisRow = parisRow + 1;
                        energy--;
                        foundHelen = true;
                    }
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        parisDead = true;
                    }
                    break;
                case "left":
                    matrix[enemyRow][enemyCol] = 'S';
                    if (!isInBounds(matrix, parisRow, parisCol - 1)) {
                        energy--;
                    } else if (matrix[parisRow][parisCol - 1] == '-') {
                        matrix[parisRow][parisCol - 1] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisCol = parisCol - 1;
                        energy--;
                    } else if (matrix[parisRow][parisCol - 1] == 'S') {
                        matrix[parisRow][parisCol - 1] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisCol = parisCol - 1;
                        energy--;
                        energy -= 2;

                    } else if (matrix[parisRow][parisCol - 1] == 'H') {
                        matrix[parisRow][parisCol - 1] = '-';
                        matrix[parisRow][parisCol] = '-';
                        parisCol = parisCol - 1;
                        energy--;
                        foundHelen = true;
                    }
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        parisDead = true;
                    }
                    break;
                case "right":
                    matrix[enemyRow][enemyCol] = 'S';
                    if (!isInBounds(matrix, parisRow, parisCol + 1)) {
                        energy--;
                    } else if (matrix[parisRow][parisCol + 1] == '-') {
                        matrix[parisRow][parisCol + 1] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisCol = parisCol + 1;
                        energy--;
                    } else if (matrix[parisRow][parisCol + 1] == 'S') {
                        matrix[parisRow][parisCol + 1] = matrix[parisRow][parisCol];
                        matrix[parisRow][parisCol] = '-';
                        parisCol = parisCol + 1;
                        energy--;
                        energy -= 2;

                    } else if (matrix[parisRow][parisCol + 1] == 'H') {
                        matrix[parisRow][parisCol + 1] = '-';
                        matrix[parisRow][parisCol] = '-';
                        parisCol = parisCol + 1;
                        energy--;
                        foundHelen = true;
                    }
                    if (energy <= 0) {
                        matrix[parisRow][parisCol] = 'X';
                        parisDead = true;
                    }
                    break;


            }


        }
        if (parisDead && !foundHelen) {
            System.out.println(String.format("Paris died at %d;%d.", parisRow, parisCol));
        }
        if (foundHelen) {
            System.out.println(String.format("Paris has successfully abducted Helen! Energy left: %d", energy));
        }
        printMatrix(matrix);


    }

    private static boolean isInBounds(char[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }
}