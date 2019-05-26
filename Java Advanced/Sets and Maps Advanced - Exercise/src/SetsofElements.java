import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetsofElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int sum = nm[0] + nm[1];
        Set<String> firstNums = new LinkedHashSet<>();
        Set<String> secondNums = new LinkedHashSet<>();
        String input = reader.readLine();
        while (sum-- > 0) {
            if (sum >= nm[1]) {
                firstNums.add(input);
            } else {
                secondNums.add(input);
            }
            input = reader.readLine();
        }
        firstNums.retainAll(secondNums);
        firstNums.forEach(e -> System.out.print(e + " "));
    }
}
