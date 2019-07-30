import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquareRoot {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            calculateSquareRoot(n);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Good bye");

        }

    }

    public static double calculateSquareRoot(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        return Math.sqrt(n);
    }

}
