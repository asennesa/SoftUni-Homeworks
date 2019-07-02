package CardSuitx2;

public class Main {
    public static void main(String[] args) {
        CardSuit[] enums = CardSuit.values();
        System.out.println("Card Suits:");
        for (CardSuit anEnum : enums) {
            System.out.println(String.format("Ordinal value: %d; Name value: %s", anEnum.ordinal(), anEnum));
        }
    }


}
