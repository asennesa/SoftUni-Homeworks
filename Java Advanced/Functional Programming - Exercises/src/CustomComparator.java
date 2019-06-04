import java.util.*;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        Comparator<Integer> integerComparator = (a, b) -> {
            boolean aEvenTest = a % 2 == 0;
            boolean bEvenTest = b % 2 == 0;
            if (aEvenTest && !bEvenTest) {
                return -1;
            } else if (!aEvenTest && bEvenTest) {
                return 1;
            } else {
                return a - b;
            }
        };

        Collections.sort(nums, integerComparator);
        nums.forEach(e -> System.out.printf("%d ", e));
    }
}