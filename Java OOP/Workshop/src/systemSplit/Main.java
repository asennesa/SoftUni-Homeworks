package systemSplit;

import systemSplit.hardware.PowerHardware;

public class Main {
    public static void main(String[] args) {
        SystemSplit systemSplit = new SystemSplit();

        systemSplit.RegisterPowerHardware("HDD", 200, 200);
        systemSplit.RegisterHeavyHardware("SSD", 400, 400);
        systemSplit.Analyze();
        systemSplit.RegisterLightSoftware("HDD", "Test", 0, 10);
        systemSplit.RegisterExpressSoftware("HDD", "Test2", 100, 100);
        systemSplit.RegisterExpressSoftware("HDD", "Test3", 50, 100);
        systemSplit.RegisterLightSoftware("SSD", "Windows", 20, 50);
        systemSplit.RegisterExpressSoftware("SSD", "Linux", 50, 100);
        systemSplit.RegisterLightSoftware("SSD", "Unix", 20, 50);
        systemSplit.Analyze();
        systemSplit.ReleaseSoftwareComponent("SSD", "Linux");
        systemSplit.systemSplit();


    }
}
