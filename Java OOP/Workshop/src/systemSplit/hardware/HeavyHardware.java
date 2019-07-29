package systemSplit.hardware;

public class HeavyHardware extends Hardware {
    public HeavyHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Heavy", maximumCapacity, maximumMemory);
    }

    @Override
    public int getMaximumCapacity() {
        int capacity = super.getMaximumCapacity();
        return capacity * 2;
    }

    @Override
    public int getMaximumMemory() {
        int memory = super.getMaximumMemory();
        return (memory - (memory / 4));
    }
}
