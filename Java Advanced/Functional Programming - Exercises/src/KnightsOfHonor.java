import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Consumer<String> printer = s -> System.out.println("Sir " + s);
        Arrays.stream(reader.readLine().split("\\s+")).forEach(printer);
    }
}
