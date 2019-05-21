import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MatrixPalindrome {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] rolCol = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[rolCol[0]][rolCol[1]];

        int[] firstThree = new int[3];
        int startLetter = 97;
        for (int row = 0; row < matrix.length; row++) {
            firstThree[0] = 97 + row;
            firstThree[2] = 97 + row;
            for (int col = 0; col < matrix[row].length; col++) {
                firstThree[1] = startLetter + row + col;
                System.out.print((char) firstThree[0]);
                System.out.print((char) firstThree[1]);
                System.out.print((char) firstThree[0] + " ");
            }
            System.out.println();

        }
    }
}