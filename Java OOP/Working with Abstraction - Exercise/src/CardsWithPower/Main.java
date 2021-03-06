package CardsWithPower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String rank = reader.readLine();
        String suit = reader.readLine();
        System.out.println("Card name: " + rank + " of " + suit + "; " + "Card power: " + (CardsWithPower.valueOf(rank).getRankPower()
                + CardsWithPower.valueOf(suit).getRankPower()));
    }
}
