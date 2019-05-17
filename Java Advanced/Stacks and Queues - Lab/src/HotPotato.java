import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class HotPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] children = reader.readLine().split("\\s+");
        int n  = Integer.valueOf(reader.readLine());

        ArrayDeque<String>queueHere = new ArrayDeque<>();
        for (String child : children)
            queueHere.offer(child);

        while (queueHere.size() > 1) {
            //Б реално време вътриш топката между играчите .
            for (int i = 1; i < n; i++)
                queueHere.offer(queueHere.poll());

            System.out.println("Removed " + queueHere.poll());
        }

        System.out.println("Last is " + queueHere.poll());


    }
}
