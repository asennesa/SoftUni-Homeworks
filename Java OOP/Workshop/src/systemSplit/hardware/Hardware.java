package systemSplit.hardware;

import systemSplit.SystemSplit;
import systemSplit.software.Software;

import java.util.ArrayList;
import java.util.List;

public abstract class Hardware extends SystemSplit {
    private String name;
    private String type;
    private int capacityInUse = 0;
    private int memoryInUse = 0;
    private int maximumCapacity;
    private int maximumMemory;
    private List<Software> softwareList;


    public Hardware(String name, String type, int maximumCapacity, int maximumMemory) {
        this.name = name;
        this.type = type;
        this.maximumCapacity = maximumCapacity;
        this.maximumMemory = maximumMemory;
        this.softwareList = new ArrayList<>();
    }


    public int getMaximumCapacity() {
        return this.maximumCapacity;
    }

    public int getMaximumMemory() {
        return this.maximumMemory;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public void setCapacityInUse(int capacityInUse) {
        this.capacityInUse = capacityInUse;
    }

    public void setMemoryInUse(int memoryInUse) {
        this.memoryInUse = memoryInUse;
    }

    public int getCapacityInUse() {
        return capacityInUse;
    }

    public int getMemoryInUse() {
        return memoryInUse;
    }
}
