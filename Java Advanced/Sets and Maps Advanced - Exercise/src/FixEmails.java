import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class FixEmails {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        while (!name.equalsIgnoreCase("stop")) {
            String email = reader.readLine();
            if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                emails.put(name, email);
            }
            name = reader.readLine();
        }
        emails.forEach((key, vale) -> {
            System.out.println(String.format("%s -> %s", key, vale));
        });
    }
}
