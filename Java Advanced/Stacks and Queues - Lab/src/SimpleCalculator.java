import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //exp - 2 + 5 + 10 - 2 - 1

        ArrayDeque<String> stack = new ArrayDeque<>();
        String[] expression = reader.readLine().split("\\s+");
        stack.addAll(Arrays.asList(expression));


        while (stack.size()!=1) {
            int firstNum = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int secondNum = Integer.parseInt(stack.pop());

            if(operator.equalsIgnoreCase("+")){
                stack.push(firstNum+secondNum + "");
            }else{
                stack.push(firstNum - secondNum + "");
            }




        }
        System.out.println(stack.pop());


    }
}