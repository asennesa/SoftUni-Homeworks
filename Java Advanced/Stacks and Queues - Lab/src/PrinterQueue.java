import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String>queueHere = new ArrayDeque<>();

        String input = "";

        while(!"print".equalsIgnoreCase(input = reader.readLine())){
            if(!input.equalsIgnoreCase("cancel")){
                queueHere.offer(input);
            }else {
                if (!queueHere.isEmpty()) {
                    System.out.println("Canceled " + queueHere.poll());
                }else{
                    System.out.println("Printer is on standby");
                }
            }


        }
        if(!queueHere.isEmpty()){
            while(!queueHere.isEmpty()){
                System.out.println(queueHere.poll());
            }
        }

    }
}
