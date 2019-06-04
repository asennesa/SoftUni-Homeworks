
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

public class ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(reader.readLine());
        List<Integer> numsToDivide = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> divisibleNums = new LinkedList<>();
        BiPredicate<Integer, Integer> divisionTest = (x, y) -> x % y == 0;

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int num : numsToDivide) {
                if (divisionTest.test(i, num)) {
                    count++;
                }
            }
            if (count == numsToDivide.size()) {
                divisibleNums.add(i);
            }
        }
        divisibleNums.forEach(e -> System.out.printf("%d ", e));
    }

}
