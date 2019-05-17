import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class DecimaltoBinaryConverter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int decimal = Integer.parseInt(reader.readLine());
        ArrayDeque<Integer> stackHere = new ArrayDeque<>();
        if (decimal == 0) {
            System.out.println("0");
        } else {
            while (decimal != 0) {
                stackHere.push(decimal % 2);
                decimal /= 2;
            }
            while (!stackHere.isEmpty()) {
                System.out.print(stackHere.pop());
            }
        }
    }
}
