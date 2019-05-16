import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class ReverseNumberswithaStack {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String> stack = new ArrayDeque<>();
        Arrays.stream(reader.readLine().split("\\s+")).forEach(e->stack.push(e));
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+ " ");
        }


    }
}
