import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class MathPotato {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] children = reader.readLine().split("\\s+");
        int n  = Integer.valueOf(reader.readLine());

        ArrayDeque<String> queueHere = new ArrayDeque<>();
        for (String child : children)
            queueHere.offer(child);
        int cycle = 1;
        while (queueHere.size() > 1) {
            for (int i = 1; i < n; i++)
                queueHere.offer(queueHere.poll());

            if (isPrime(cycle)){
                System.out.println("Prime " + queueHere.peek());
            } else {
                System.out.println("Removed " + queueHere.poll());
            }
            cycle++;
        }
        System.out.println("Last is " + queueHere.poll());




    }
    public static boolean isPrime(int n) {
        if(n < 2) return false;
        if(n == 2 || n == 3) return true;
        if(n%2 == 0 || n%3 == 0) return false;
        long sqrtN = (long)Math.sqrt(n)+1;
        for(long i = 6L; i <= sqrtN; i += 6) {
            if(n%(i-1) == 0 || n%(i+1) == 0) return false;
        }
        return true;
    }
    }
