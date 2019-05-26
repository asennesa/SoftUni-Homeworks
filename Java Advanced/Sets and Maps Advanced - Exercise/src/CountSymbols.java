import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        Map<Character, Integer> countSymbols = new TreeMap<>();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (!countSymbols.containsKey(currentChar)) {
                countSymbols.put(currentChar, 1);
            } else {
                countSymbols.put(currentChar, countSymbols.get(currentChar) + 1);
            }

        }
        countSymbols.forEach((key, value) -> {
            System.out.println(String.format("%c: %d time/s", key, value));
        });
    }
}
