import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> elements = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] str = reader.readLine().split("\\s+");
            for (int j = 0; j < str.length; j++) {
                elements.add(str[j]);
            }
        }
        elements.forEach(e -> System.out.print(e + " "));
    }
}
