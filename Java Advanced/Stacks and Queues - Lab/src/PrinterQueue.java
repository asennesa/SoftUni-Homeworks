import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class PrinterQueue {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<String>queue = new ArrayDeque<>();

        String input = "";

        while(!"print".equalsIgnoreCase(input = reader.readLine())){
            if(!input.equalsIgnoreCase("cancel")){
                queue.offer(input);
            }else {
                if (!queue.isEmpty()) {
                    System.out.println("Canceled " + queue.poll());
                }else{
                    System.out.println("Printer is on standby");
                }
            }


        }
        if(!queue.isEmpty()){
            while(!queue.isEmpty()){
                System.out.println(queue.poll());
            }
        }

    }
}
