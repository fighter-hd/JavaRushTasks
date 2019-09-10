package com.javarush.task.task36.task3601;

public class View {
    public void fireShowDataEvent() {
        System.out.println(new Controller().onShowDataList());
    }
}
