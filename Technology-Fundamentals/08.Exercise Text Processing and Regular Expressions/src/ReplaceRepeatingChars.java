import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReplaceRepeatingChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        StringBuilder sb = new StringBuilder(input);
        int counter = 0;
        for (int i = 0; i < sb.length(); i++) {

            for (int j = i; j < sb.length(); j++) {
                if (sb.charAt(j) == sb.charAt(i)) {
                    counter++;
                } else {
                    break;
                }

            }
            sb.replace(i, counter + i, String.valueOf(sb.charAt(i)));
            counter = 0;


        }
        System.out.println(sb.toString());


    }
}
