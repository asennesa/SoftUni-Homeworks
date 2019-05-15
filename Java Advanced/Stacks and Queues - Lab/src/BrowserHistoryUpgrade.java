import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        ArrayDeque<String> stackHere = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();

        while(!"home".equalsIgnoreCase(input=reader.readLine())){

            if(!input.equalsIgnoreCase("Back")){
                stackHere.push(input);
                System.out.println(input);
            }else{
                if(stackHere.size() > 1){
                    queue.offer(stackHere.pop());
                    System.out.println(stackHere.peek());

                }else {
                    System.out.println("no previous URLs");
                }
            }



        }
    }
}