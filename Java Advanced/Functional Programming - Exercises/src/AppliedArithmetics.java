import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> nums = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).boxed()
                .collect(Collectors.toCollection(ArrayList::new));

        String input = "";
        Consumer<ArrayList<Integer>> printer = list -> list.forEach(e -> System.out.print(e + " "));
        Function<ArrayList<Integer>, ArrayList<Integer>> add = list -> list.stream().map(e -> ++e).collect(Collectors.toCollection(ArrayList::new));
        UnaryOperator<ArrayList<Integer>> multy = list -> list.stream().map(e -> e *= 2).collect(Collectors.toCollection(ArrayList::new));
        UnaryOperator<ArrayList<Integer>> subtr = list -> list.stream().map(e -> --e).collect(Collectors.toCollection(ArrayList::new));
        while (!"END".equalsIgnoreCase(input = reader.readLine())) {
            switch (input) {
                case "add":
                    nums = add.apply(nums);

                    break;
                case "multiply":
                    nums = multy.apply(nums);

                    break;
                case "subtract":
                    nums = subtr.apply(nums);

                    break;
                case "print":
                    printer.accept(nums);
                    System.out.println();

                    break;
            }
        }

    }
}
