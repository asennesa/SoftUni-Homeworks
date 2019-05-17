import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        ArrayDeque<String> stackHere = new ArrayDeque<>();
        ArrayDeque<String> queueHere = new ArrayDeque<>();

        while(!"home".equalsIgnoreCase(input=reader.readLine())){

            if(!input.equalsIgnoreCase("Back")&& !input.equalsIgnoreCase("forward")){
                stackHere.push(input);
                System.out.println(input);
            }else if (input.equalsIgnoreCase("Back")){
                if(stackHere.size() > 1){
                    queueHere.addFirst(stackHere.peek());
                    stackHere.pop();
                    System.out.println(stackHere.peek());

                }else {
                    System.out.println("no previous URLs");
                }
            }
            if (input.equalsIgnoreCase("forward")){

                if(queueHere.isEmpty()){
                    System.out.println("no next URLs");
                }else{
                    stackHere.push(queueHere.peek());
                    System.out.println(queueHere.poll());
                }
            }else if (!input.equalsIgnoreCase("back") && !input.equalsIgnoreCase("forward")){
                queueHere.clear();
            }




        }
    }
}