import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class VoinaNumberGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Integer> firstPlayer = getPlayerCards(reader.readLine());

        Set<Integer> secondPlayer = getPlayerCards(reader.readLine());
        for (int round = 0; round < 50; round++) {
            if (firstPlayer.isEmpty() || secondPlayer.isEmpty()) break;
            // Iterator gives the next element if there is one.
            Iterator<Integer> firstPlayerIterate = firstPlayer.iterator();
            Iterator<Integer> secondPlayerIterate = secondPlayer.iterator();
            int firstPlayerValue = firstPlayerIterate.next();
            firstPlayer.remove(firstPlayerValue);
            int secondPlayerValue = secondPlayerIterate.next();
            secondPlayer.remove(secondPlayerValue);

            if (firstPlayerValue > secondPlayerValue) {
                firstPlayer.add(firstPlayerValue);
                firstPlayer.add(secondPlayerValue);
            } else if (firstPlayerValue < secondPlayerValue) {
                secondPlayer.add(firstPlayerValue);
                secondPlayer.add(secondPlayerValue);
            } else {
                firstPlayer.add(firstPlayerValue);
                secondPlayer.add(secondPlayerValue);

            }
        }
        if (firstPlayer.size() > secondPlayer.size()) {
            System.out.println("First player win!");
        } else if (secondPlayer.size() > firstPlayer.size()) {
            System.out.println("Second player win!");
        } else {
            System.out.println("Draw!");
        }
    }

    static LinkedHashSet<Integer> getPlayerCards(String line) {
        LinkedHashSet<Integer> result = new LinkedHashSet<>();
        Arrays.stream(line.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(result::add);
        return result;
    }
}
