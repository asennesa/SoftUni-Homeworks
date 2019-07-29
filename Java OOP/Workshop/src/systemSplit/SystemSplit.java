package systemSplit;

import systemSplit.hardware.Hardware;
import systemSplit.hardware.HeavyHardware;
import systemSplit.hardware.PowerHardware;
import systemSplit.software.ExpressSoftware;
import systemSplit.software.LightSoftware;
import systemSplit.software.Software;

import java.util.LinkedHashMap;
import java.util.Map;

public class SystemSplit {
    private Map<String, Hardware> hardwareMap;

    public SystemSplit() {
        this.hardwareMap = new LinkedHashMap<>();
    }

    public void RegisterPowerHardware(String name, int capacity, int memory) {
        PowerHardware powerHardware = new PowerHardware(name, capacity, memory);
        hardwareMap.put(name, powerHardware);
    }

    public void RegisterHeavyHardware(String name, int capacity, int memory) {
        HeavyHardware heavyHardware = new HeavyHardware(name, capacity, memory);
        hardwareMap.put(name, heavyHardware);
    }

    public void RegisterExpressSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (hardwareMap.containsKey(hardwareComponentName)) {
            ExpressSoftware expressSoftware = new ExpressSoftware(name, capacity, memory);
            if (capacity + hardwareMap.get(hardwareComponentName).getCapacityInUse() <=
                    hardwareMap.get(hardwareComponentName).getMaximumCapacity()) {

                hardwareMap.get(hardwareComponentName).getSoftwareList().add(expressSoftware);
                hardwareMap.get(hardwareComponentName).setCapacityInUse(hardwareMap.get(hardwareComponentName).getCapacityInUse() + capacity);
                hardwareMap.get(hardwareComponentName).setMemoryInUse(hardwareMap.get(hardwareComponentName).getMemoryInUse() + capacity);
            }
        }
    }

    public void RegisterLightSoftware(String hardwareComponentName, String name, int capacity, int memory) {
        if (hardwareMap.containsKey(hardwareComponentName)) {
            LightSoftware lightSoftware = new LightSoftware(name, capacity, memory);
            if (capacity + hardwareMap.get(hardwareComponentName).getCapacityInUse() <=
                    hardwareMap.get(hardwareComponentName).getMaximumCapacity()) {
                hardwareMap.get(hardwareComponentName).getSoftwareList().add(lightSoftware);
                hardwareMap.get(hardwareComponentName).setCapacityInUse(hardwareMap.get(hardwareComponentName).getCapacityInUse() + capacity);
                hardwareMap.get(hardwareComponentName).setMemoryInUse(hardwareMap.get(hardwareComponentName).getMemoryInUse() + capacity);
            }
        }
    }

    public void ReleaseSoftwareComponent(String hardwareComponentName, String softwareComponentName) {
        if (hardwareMap.containsKey(hardwareComponentName)) {
            for (Software software : hardwareMap.get(hardwareComponentName).getSoftwareList()) {
                if (software.getClass().getSimpleName().equals(softwareComponentName)) {
                    hardwareMap.get(hardwareComponentName).getSoftwareList().remove(software);
                }
            }

        }
    }

    public void Analyze() {
        int softwareComponentsCount = hardwareMap.values().stream().mapToInt(hardware -> hardware.getSoftwareList().size()).sum();
        int memoryInUseSum = hardwareMap.values().stream().mapToInt(Hardware::getMemoryInUse).sum();
        int maxMemory = hardwareMap.values().stream().mapToInt(Hardware::getMaximumMemory).sum();
        int capacityInUse = hardwareMap.values().stream().mapToInt(Hardware::getCapacityInUse).sum();
        int maxCapacity = hardwareMap.values().stream().mapToInt(Hardware::getCapacityInUse).sum();
        String result = String.format("SystemSplit Analysis%nHardware Components: %d%nSoftware Components: %d " +
                        "Total Operational Memory: %d / %d%nTotal Capacity Taken: %d / %d%n"
                , hardwareMap.size(), softwareComponentsCount
                , memoryInUseSum
                , maxMemory
                , capacityInUse
                , maxCapacity);

        System.out.println(result);


    }


}
