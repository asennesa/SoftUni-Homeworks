package systemSplit.software;

public abstract class Software {
    private String name;
    private String type;
    private int capacityConsumption;
    private int memoryConsumption;

    public Software(String name, String type, int capacityConsumption, int memoryConsumption) {
        this.name = name;
        this.type = type;
        this.capacityConsumption = capacityConsumption;
        this.memoryConsumption = memoryConsumption;
    }

    public String getType() {
        return type;
    }

    public int getCapacityConsumption() {
        return capacityConsumption;
    }

    public int getMemoryConsumption() {
        return memoryConsumption;
    }
}
