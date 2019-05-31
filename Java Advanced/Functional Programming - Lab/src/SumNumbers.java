import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(", ");
        System.out.println("Count = " + split.length);
        Function<String, Integer> parser = s -> Integer.parseInt(s);

        List<Integer> parsed = Arrays.stream(split).map(parser).collect(Collectors.toList());

        int sum = parsed.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum = " + sum);

    }
}
