import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

public class Phonebook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        LinkedHashMap<String, String> phoneBook = new LinkedHashMap<>();
        while (!"search".equalsIgnoreCase(input = reader.readLine())) {
            String[] split = input.split("-");
            String name = split[0];
            String number = split[1];
            if (!phoneBook.containsKey(name)) {
                phoneBook.put(name, number);
            } else {
                phoneBook.replace(phoneBook.get(name), number);
            }

        }
        while (!"stop".equalsIgnoreCase(input = reader.readLine())) {
            if (phoneBook.containsKey(input)) {
                System.out.println(String.format("%s -> %s", input, phoneBook.get(input)));
            } else {
                System.out.println(String.format("Contact %s does not exist.", input));
            }
        }
    }
}
