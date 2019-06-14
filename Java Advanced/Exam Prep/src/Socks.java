import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Socks {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> leftStack = new ArrayDeque<>();
        ArrayDeque<Integer> rightQueue = new ArrayDeque<>();
        int[] split = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] split1 = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Arrays.stream(split).forEach(leftStack::push);
        Arrays.stream(split1).forEach(rightQueue::offer);
        LinkedList<Integer> pairs = new LinkedList<>();

        int until = 0;
        if(rightQueue.size()>leftStack.size()){
            until=leftStack.size();
        }else{
            until=rightQueue.size();
        }

        while (!leftStack.isEmpty() && !rightQueue.isEmpty()) {
            int leftSock = leftStack.peek();
            int rightSock = rightQueue.peek();

            if (leftSock > rightSock) {
                int pair = leftSock + rightSock;
                leftStack.pop();
                rightQueue.poll();
                pairs.add(pair);



            } else if (rightSock > leftSock) {
                leftStack.pop();


            }
            if (leftSock == rightSock) {
                rightQueue.poll();
                leftSock += 1;
                leftStack.pop();
                leftStack.addFirst(leftSock);


            }


        }
        System.out.println(Collections.max(pairs));
        pairs.forEach(p -> System.out.print(p + " "));


    }
}
