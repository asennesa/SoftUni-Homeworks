import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        List<Integer> nums = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(reader.readLine());
        Collections.reverse(nums);
        Predicate<Integer> divByTwo = e -> e % n != 0;
        Consumer<Integer> printer = (e -> System.out.print(e + " "));
        nums.stream().filter(divByTwo).forEach(printer);

    }
}
