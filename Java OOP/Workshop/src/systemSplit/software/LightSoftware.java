package systemSplit.software;

public class LightSoftware extends Software {
    public LightSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "Light", capacityConsumption, memoryConsumption);
    }

    @Override
    public int getCapacityConsumption() {
        return super.getCapacityConsumption() + (super.getCapacityConsumption() / 2);
    }

    @Override
    public int getMemoryConsumption() {
        return super.getMemoryConsumption() / 2;
    }
}
