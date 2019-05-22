import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class StringMatrixRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        ArrayList<String> wholeInput = new ArrayList<>();

        String command = reader.readLine();
        String filtered = command.replaceAll("[A-Za-z]+\\(|\\)$", "");
        while (!"end".equalsIgnoreCase(input = reader.readLine())) {
            wholeInput.add(input);
        }
        String max = Collections.max(wholeInput, Comparator.comparing(e -> e.length()));


        if (Integer.parseInt(filtered) % 360 == 90) {
            String[][] matrix90 = new String[max.length()][wholeInput.size()];
            Collections.reverse(wholeInput);
            for (int col = 0; col < wholeInput.size(); col++) {
                String[] currentSplit = wholeInput.get(col).split("");
                for (int row = 0; row < max.length(); row++) {
                    if (row >= wholeInput.get(col).length()) {
                        matrix90[row][col] = " ";
                    } else {
                        matrix90[row][col] = currentSplit[row];
                    }

                }
            }
            printMatrix(matrix90);

        }
        if (Integer.parseInt(filtered) % 360 == 180) {
            String[][] matrix180 = new String[wholeInput.size()][max.length()];
            Collections.reverse(wholeInput);
            for (int row = 0; row < matrix180.length; row++) {
                int counter = -1;
                String reverse = reverse(wholeInput.get(row));
                String[] currentSplit = reverse.split("");
                int spaceLimit = max.length() - reverse.length();
                for (int col = 0; col < max.length(); col++) {
                    if (col < spaceLimit) {
                        matrix180[row][col] = " ";
                    } else {
                        counter++;
                        matrix180[row][col] = currentSplit[counter];
                    }
                }
            }
            printMatrix(matrix180);
        }
        if (Integer.parseInt(filtered) % 360 == 270) {
            String[][] matrix270 = new String[max.length()][wholeInput.size()];
            for (int col = 0; col < wholeInput.size(); col++) {
                int counter = -1;
                String reverse = reverse(wholeInput.get(col));
                String[] currentSplit = reverse.split("");
                int spaceLimit = max.length() - wholeInput.get(col).length();
                for (int row = 0; row < max.length(); row++) {
                    if (row < spaceLimit) {
                        matrix270[row][col] = " ";
                    } else {
                        counter++;
                        matrix270[row][col] = currentSplit[counter];
                    }

                }
            }
            printMatrix(matrix270);

        }
        if (Integer.parseInt(filtered) % 360 == 0) {
            String[][] matrix = new String[wholeInput.size()][max.length()];
            for (int row = 0; row < wholeInput.size(); row++) {
                String[] currentSplit = wholeInput.get(row).split("");
                for (int col = 0; col < max.length(); col++) {
                    if (col >= wholeInput.get(row).length()) {
                        matrix[row][col] = " ";
                    } else {
                        matrix[row][col] = currentSplit[col];
                    }

                }
            }
            printMatrix(matrix);

        }

    }

    private static void printMatrix(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                System.out.print(matrix[r][c]);
            }
            System.out.println();
        }
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}
