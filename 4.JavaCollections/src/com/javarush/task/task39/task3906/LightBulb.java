package com.javarush.task.task39.task3906;

public class LightBulb implements Switchable {
    private boolean on = false;

    @Override
    public boolean isOn() {
        return on;
    }

    @Override
    public void turnOff() {
        System.out.println("The light is off!");
        on = false;
    }

    @Override
    public void turnOn() {
        System.out.println("The light is on!");
        on = true;
    }
}
