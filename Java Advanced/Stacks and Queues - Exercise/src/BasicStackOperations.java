import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class BasicStackOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] parameters = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int elementsCount =parameters[0];
        int countToRemove =parameters[1];
        int lookupElement =parameters[2];

        Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).limit(elementsCount).forEach(stack::push);
         while (countToRemove-- >0){
             stack.pop();
         }
         if(stack.contains(lookupElement)){
             System.out.println("true");
         }else{
             if(stack.size()== 0){
                 System.out.println(0);
             }else{
                // System.out.println(Collections.min(stack));
                 int min = Integer.MAX_VALUE;
                 while(!stack.isEmpty()){
                     int number = stack.pop();
                     if(number<min){
                         min = number;
                     }
                 }
                 System.out.println(min);
             }

         }



    }
}
