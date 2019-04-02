import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class validUsername {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] data = reader.readLine().split(", ");
        boolean flag;
        for (String datum : data) {
            flag = datum.length() >= 3 && datum.length() <= 16;
            if (!flag) {
                continue;
            }

            for (int j = 0; j < datum.length(); j++) {
                if (!Character.isLetterOrDigit(datum.charAt(j)) && datum.charAt(j) != '-' && datum.charAt(j) != '_') {
                    flag = false;
                    break;

                }
            }

            if (flag) {
                System.out.println(datum);
            }

        }
    }
}

