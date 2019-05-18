import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class BasicQueueOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] NSX = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int N = NSX[0];
        int S = NSX[1];
        int X = NSX[2];
        int[] nums = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).limit(N).toArray();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(nums).forEach(e -> queue.offer(e));
        while (S != 0) {
            queue.poll();
            S--;
        }
        if (queue.contains(X)) {
            System.out.println("true");
        } else if (queue.size() > S) {
            int min = Integer.MAX_VALUE;
            while (!queue.isEmpty()) {
                int num = queue.poll();
                if (num < min) {
                    min = num;
                }
            }
            System.out.println(min);
        } else if (queue.isEmpty()) {
            System.out.println(0);
        }


    }
}
