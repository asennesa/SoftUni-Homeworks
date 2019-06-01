import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Predicate<Integer> filterEven = x -> x % 2 == 0;
        Predicate<Integer> filterOdd = x -> x % 2 != 0;
        String[] lowerUpper = reader.readLine().split(" ");
        int lowerBound = Integer.parseInt(lowerUpper[0]);
        int upperBound = Integer.parseInt(lowerUpper[1]);
        String type = reader.readLine();

        Predicate<Integer> byType = filterEven;
        if (type.equals("odd")) {
            byType = filterOdd;
        }
        IntStream.rangeClosed(lowerBound, upperBound)
                .boxed()
                .filter(byType)
                .forEach(x -> System.out.print(x + " "));

    }
}
