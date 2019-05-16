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

            if(!input.equalsIgnoreCase("Back")&& !input.equalsIgnoreCase("forward")){
                stackHere.push(input);
                System.out.println(input);
            }else if (input.equalsIgnoreCase("Back")){
                if(stackHere.size() > 1){
                    queue.offer(stackHere.peek());
                    stackHere.pop();
                    System.out.println(stackHere.peek());

                }else {
                    System.out.println("no previous URLs");
                }
            }
            if (input.equalsIgnoreCase("forward")){

                if(queue.isEmpty()){
                    System.out.println("no next URLs");
                }else{
                    stackHere.push(queue.peek());
                    System.out.println(queue.poll());
                }
            }else if (!input.equalsIgnoreCase("back") && !input.equalsIgnoreCase("forward")){
                queue.clear();
            }




        }
    }
}