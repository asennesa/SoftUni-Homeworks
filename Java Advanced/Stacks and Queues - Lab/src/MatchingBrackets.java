import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MatchingBrackets {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String expression = reader.readLine();
        ArrayDeque<Integer> stackHere = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                stackHere.push(i);
            } else if (ch == ')') {
                int startIndex = stackHere.pop();
                String contents = expression.substring(startIndex, i + 1);
                System.out.println(contents);
            }
        }

    }
}
