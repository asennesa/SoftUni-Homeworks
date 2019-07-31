package systemSplit;

import systemSplit.hardware.Hardware;
import systemSplit.hardware.HeavyHardware;
import systemSplit.hardware.PowerHardware;
import systemSplit.software.ExpressSoftware;
import systemSplit.software.LightSoftware;
import systemSplit.software.Software;

import java.util.LinkedHashMap;
import java.util.List;
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
        int maxCapacity = hardwareMap.values().stream().mapToInt(Hardware::getMaximumCapacity).sum();
        String result = String.format("SystemSplit Analysis%nHardware Components: %d%nSoftware Components: %d%n" +
                        "Total Operational Memory: %d / %d%nTotal Capacity Taken: %d / %d%n"
                , hardwareMap.size(), softwareComponentsCount
                , memoryInUseSum
                , maxMemory
                , capacityInUse
                , maxCapacity);

        System.out.println(result);


    }

    String result = String.format("Hardware Component – {componentName}%n" +
            "Express Software Components - {countOfExpressSoftwareComponents}%n" +
            "Light Software Components - {countOfLightSoftwareComponents}%n" +
            "Memory Usage: {memoryUsed} / {maximumMemory}%n" +
            "Capacity Usage: {capacityUsed} / {maximumCapacity}%n" +
            "Type: {Power/Heavy}%n" +
            "Software Components: {softwareComponent1, softwareComponent2…}");

    public void systemSplit() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Hardware> stringHardwareEntry : hardwareMap.entrySet()) {
            sb.append("Hardware Component – ").append(stringHardwareEntry.getKey()).append(System.lineSeparator());
            List<Software> softwares = stringHardwareEntry.getValue().getSoftwareList();
            long expressSoftwareCount = softwares.stream().filter(e -> e.getType().equalsIgnoreCase("Express")).count();
            sb.append("Express Software Components – ").append(expressSoftwareCount).append(System.lineSeparator());
            long lightSoftwareCount = softwares.stream().filter(e -> e.getType().equalsIgnoreCase("Light")).count();
            sb.append("Light Software Components - ").append(lightSoftwareCount).append(System.lineSeparator());
            sb.append("Memory Usage: ").append(stringHardwareEntry.getValue().getMemoryInUse()).append(" / ")
                    .append(stringHardwareEntry.getValue().getMaximumMemory()).append(System.lineSeparator());
            sb.append("Capacity Usage: ").append(stringHardwareEntry.getValue().getCapacityInUse()).append(" / ")
                    .append(stringHardwareEntry.getValue().getMaximumCapacity()).append(System.lineSeparator());
            sb.append("Type: ").append(stringHardwareEntry.getValue().getType()).append(System.lineSeparator());
            sb.append("Software Components: ");
            if (stringHardwareEntry.getValue().getSoftwareList().size() > 0){
                sb.append(stringHardwareEntry.getValue().getSoftwareList().toString().replaceAll("\\[|\\]", ""));
            }else{
                sb.append("None").append(System.lineSeparator());
            }
            System.out.println(sb.toString().trim());



        }


    }


}
