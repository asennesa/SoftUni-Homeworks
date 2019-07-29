package systemSplit.software;

public class ExpressSoftware extends Software {
    public ExpressSoftware(String name, int capacityConsumption, int memoryConsumption) {
        super(name, "Express", capacityConsumption, memoryConsumption);
    }


    @Override
    public int getMemoryConsumption() {
        return super.getMemoryConsumption() * 2;
    }
}
