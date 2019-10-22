package com.javarush.task.task39.task3906;

public class SecuritySystem implements Switchable {
    private boolean on = false;

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off the SecuritySystem!");
        on = false;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on the SecuritySystem!");
        on = true;
    }
}
