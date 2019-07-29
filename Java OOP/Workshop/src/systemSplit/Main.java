package systemSplit;

import systemSplit.hardware.PowerHardware;

public class Main {
    public static void main(String[] args) {
        //testing.
        SystemSplit systemSplit = new SystemSplit();
        systemSplit.RegisterPowerHardware("A", 100, 100);
        systemSplit.Analyze();


    }
}
