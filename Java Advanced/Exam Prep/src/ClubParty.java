import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ClubParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int capacity = Integer.parseInt(reader.readLine());
        ArrayDeque<String> stack = new ArrayDeque<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] input = reader.readLine().split(" ");
        Arrays.stream(input).forEach(stack::push);
        Map<String, List<Integer>> halls = new LinkedHashMap<>();
        int currentSum = 0;
        String currrentHall = "";
        while (!stack.isEmpty()) {
            if (Character.isLetter(stack.peek().charAt(0))) {
                queue.offer(stack.pop());
            }
            if (queue.isEmpty()) {
                stack.pop();
                continue;
            }
            if (stack.isEmpty()) {
                break;
            }
            if (Character.isDigit(stack.peek().charAt(0)) && stack.size() > 0) {
                currrentHall = queue.peek();
                if (currentSum + Integer.parseInt(stack.peek()) <= capacity) {
                    if (!halls.containsKey(currrentHall)) {
                        halls.put(currrentHall, new ArrayList<>());
                    } else {
                        halls.get(currrentHall).add(Integer.parseInt(stack.peek()));
                        currentSum += Integer.parseInt(stack.pop());
                    }

                } else {
                    currentSum = 0;
                    System.out.print(String.format("%s -> ", queue.peek()));
                    System.out.print(halls.get(queue.poll()).toString().replaceAll("\\[|\\]", ""));
                    System.out.println();


                }

            }

        }


    }
}
