import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> minElement = num -> {
            int min = Integer.MAX_VALUE;
            int position = 0;
            for (int i = 0; i < nums.size(); i++) {
                if (nums.get(i) <= min) {
                    min = nums.get(i);
                    position = i;
                }
            }
            return position;
        };

        System.out.println(minElement.apply(nums));
    }
}