import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CasesarCipher {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder ciphered = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            ciphered.append(String.valueOf(Character.toChars(input.charAt(i) + 3)));
        }
        System.out.println(ciphered);
    }
}
