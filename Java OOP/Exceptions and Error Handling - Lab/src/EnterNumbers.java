import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EnterNumbers {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        do {
            try {
                System.out.println("Enter values:");
                int start = Integer.parseInt(reader.readLine());
                int end = Integer.parseInt(reader.readLine());
                try {
                    printNumbers(start, end);
                } catch (IllegalArgumentException ex) {
                    System.out.println(ex.getMessage());
                }
                break;


            } catch (NumberFormatException ex) {
                System.out.println("Input must be a positive integer");
            } catch (IOException e) {
                e.printStackTrace();
            }


        } while (true);
    }

    public static void printNumbers(int start, int end) {
        if (start < 1 || start > end || end > 100) {
            throw new IllegalArgumentException("Invalid range.Use range: 1 < start < end < 100");
        }
        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }


    }
}
