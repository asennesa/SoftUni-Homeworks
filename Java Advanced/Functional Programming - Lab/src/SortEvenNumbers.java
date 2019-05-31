import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] split = reader.readLine().split(", ");

        List<String> evennums =
                Arrays.stream(split).
                        map(e -> Integer.parseInt(e)).
                        filter(e -> e % 2 == 0).
                        map(e -> String.valueOf(e)).
                        collect(Collectors.toList());

        String evenString = String.join(", ", evennums);
        System.out.println(evenString);
        List<String> sorted = evennums.stream()
                .map(e -> Integer.parseInt(e))
                .sorted((e1, e2) -> e1.compareTo(e2))
                .map(e -> String.valueOf(e))
                .collect(Collectors.toList());
        String sortedString = String.join(", ", sorted);
        System.out.println(sortedString);
    }
}
