import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] textSplit = reader.readLine().split(" ");
        Predicate<String> firstCapital = word -> Character.isUpperCase(word.charAt(0));


        List<String> filtered = Arrays.stream(textSplit)
                .filter(firstCapital)
                .collect(Collectors.toList());
        System.out.println(filtered.size());

        filtered.forEach(System.out::println);
    }
}
