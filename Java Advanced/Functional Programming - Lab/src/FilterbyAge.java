import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

public class FilterbyAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> personAge = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentPerson = reader.readLine().split(", ");
            String person = currentPerson[0];
            int age = Integer.parseInt(currentPerson[1]);
            personAge.put(person, age);
        }

        String ageCondition = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        String printType = reader.readLine();

        BiPredicate<Map.Entry<String, Integer>, Integer> younger = (p, ageLimit) -> p.getValue() <= ageLimit;
        BiPredicate<Map.Entry<String, Integer>, Integer> older = (p, ageLimit) -> p.getValue() >= ageLimit;
        Consumer<Map.Entry<String, Integer>> namePrint = p -> System.out.println(p.getKey());
        Consumer<Map.Entry<String, Integer>> nameAgePrint = p -> System.out.println(String.format("%s - %d", p.getKey(), p.getValue()));
        Consumer<Map.Entry<String, Integer>> agePrint = p -> System.out.println(p.getValue());

        personAge.entrySet()
                .stream()
                .filter(p -> ageCondition.equals("younger") ? younger.test(p, age) : older.test(p, age))
                .forEach(p -> {
                    if (printType.equals("name age")) {
                        nameAgePrint.accept(p);
                    } else if (printType.equals("name")) {
                        namePrint.accept(p);
                    } else if (printType.equals("age")) {
                        agePrint.accept(p);
                    }
                });


    }

}
