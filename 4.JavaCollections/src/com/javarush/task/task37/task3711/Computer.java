package com.javarush.task.task37.task3711;

public class Computer {
    private CPU cpu = new CPU();
    private HardDrive hardDrive = new HardDrive();
    private Memory memory = new Memory();

    void run() {
        this.cpu.calculate();
        this.memory.allocate();
        this.hardDrive.storeData();
    }
}
