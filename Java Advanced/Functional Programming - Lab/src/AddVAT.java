import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = reader.readLine().split(", ");

        System.out.println("Prices with VAT:");
        UnaryOperator<Double> addVat = num -> num = num + num * 0.2;
        Arrays.stream(nums)
                .map(Double::parseDouble)
                .map(addVat)
                .forEach(e -> System.out.printf("%.2f%n", e));
    }
}
