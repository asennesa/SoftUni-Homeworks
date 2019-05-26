import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> usernames = new LinkedHashSet<>();

        String input = reader.readLine();
        while (n-- > 0) {
            usernames.add(input);
            input = reader.readLine();
        }
        usernames.forEach(e -> System.out.println(e));
    }
}
