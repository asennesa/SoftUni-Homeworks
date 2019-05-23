import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class CountRealNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double[] input = Arrays.stream(reader.readLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        LinkedHashMap<Double, Integer> valueOccurrence = new LinkedHashMap<>();
        for (double v : input) {
            if (!valueOccurrence.containsKey(v)) {
                valueOccurrence.put(v, 1);
            } else {
                valueOccurrence.put(v, valueOccurrence.get(v) + 1);
            }

        }
        valueOccurrence.forEach((key, value) -> System.out.println(String.format("%.1f -> %s", key, value)));
    }
}
