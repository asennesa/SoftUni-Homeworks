import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class TrojanInvasion {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfWaves = Integer.parseInt(reader.readLine());
        int[] platesSplit = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        Arrays.stream(platesSplit).forEach(queue::offer);

        for (int i = 1; i <= numberOfWaves; i++) {
            if (queue.isEmpty()) {
                break;
            }
            int[] waveSplit = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            Arrays.stream(waveSplit).forEach(stack::push);
            if (i % 3 == 0) {
                queue.offer(Integer.parseInt(reader.readLine()));
            }
            while (!stack.isEmpty() && !queue.isEmpty()) {

                int currentWarior = stack.peek();
                int currentPlate = queue.peek();
                if (currentWarior > currentPlate) {
                    currentWarior = currentWarior - currentPlate;
                    queue.poll();
                    stack.pop();
                    stack.addFirst(currentWarior);
                } else if (currentWarior == currentPlate) {
                    stack.pop();
                    queue.poll();
                } else if (currentPlate > currentWarior) {
                    currentPlate = currentPlate - currentWarior;
                    stack.poll();
                    queue.poll();
                    queue.addFirst(currentPlate);
                }
            }


        }
        if (queue.isEmpty()) {
            System.out.println("The Trojans successfully destroyed the Spartan defense.");
            System.out.print("Warriors left: ");
            System.out.println((stack.toString().replaceAll("\\[|\\]", "")));

        } else {
            System.out.println("The Spartans successfully repulsed the Trojan attack.");
            System.out.print("Plates left: ");
            System.out.println((queue.toString().replaceAll("\\[|\\]", "")));

        }
    }
}
