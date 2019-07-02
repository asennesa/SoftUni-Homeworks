package CardSuit;

public enum CardSuit {
    CLUBS(0),
    DIAMONDS(1),
    HEARTS(2),
    SPADES(3),
    ;
    private int ordinalValue;

    CardSuit(int ordinalValue) {
        this.ordinalValue = ordinalValue;
    }

    @Override
    public String toString() {
        return String.format("Ordinal value: %d; Name value: %s", ordinalValue, name());
    }
}
