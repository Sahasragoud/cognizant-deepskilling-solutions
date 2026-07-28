package org.javaclaseses;

public class BuilderPatternTest {

    public static void main(String[] args) {

        Computer gamingPC = new Computer.Builder()
                .setCpu("Intel Core i9")
                .setRam(32)
                .setStorage(1000)
                .setGraphicsCard("NVIDIA RTX 4080")
                .setOperatingSystem("Windows 11")
                .build();

        Computer officePC = new Computer.Builder()
                .setCpu("Intel Core i5")
                .setRam(16)
                .setStorage(512)
                .setOperatingSystem("Windows 10")
                .build();

        gamingPC.displayConfiguration();
        officePC.displayConfiguration();
    }
}