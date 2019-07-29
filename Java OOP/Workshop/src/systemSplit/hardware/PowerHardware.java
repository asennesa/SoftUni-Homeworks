package systemSplit.hardware;

public class PowerHardware extends Hardware {
    public PowerHardware(String name, int maximumCapacity, int maximumMemory) {
        super(name, "Power", maximumCapacity, maximumMemory);
    }

    @Override
    public int getMaximumCapacity() {
        int capacity = super.getMaximumCapacity();
        return (capacity - ((capacity * 3) / 4));
    }

    @Override
    public int getMaximumMemory() {
        int memory = super.getMaximumMemory();
        return (memory + ((memory * 3) / 4));
    }


}
