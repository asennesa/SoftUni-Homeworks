import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class SimpleCalculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //exp - 2 + 5 + 10 - 2 - 1

        ArrayDeque<String> stackHere = new ArrayDeque<>();
        String[] expression = reader.readLine().split("\\s+");
        stackHere.addAll(Arrays.asList(expression));


        while (stackHere.size()!=1) {
            int firstNum = Integer.parseInt(stackHere.pop());
            String operator = stackHere.pop();
            int secondNum = Integer.parseInt(stackHere.pop());

            if(operator.equalsIgnoreCase("+")){
                stackHere.push(firstNum+secondNum + "");
            }else{
                stackHere.push(firstNum - secondNum + "");
            }




        }
        System.out.println(stackHere.pop());


    }
}