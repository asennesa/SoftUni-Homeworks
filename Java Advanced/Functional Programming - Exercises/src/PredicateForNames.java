import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class PredicateForNames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(reader.readLine());
        String[] names = reader.readLine().split(" ");
        Predicate<String> lengthTest = name -> name.length() <= length;
        Consumer<String> printer = name -> System.out.println(name);
        Arrays.stream(names).filter(lengthTest).forEach(printer);
    }
}
