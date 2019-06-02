package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    private Thread target;
    private Thread.State targetState;


    public LoggingStateThread(Thread target) {
        this.target = target;
        targetState = target.getState();
//        setDaemon(true);
    }

    @Override
    public void run() {
        System.out.println(targetState);

        while(true) {
            if (targetState != target.getState()) {
                targetState = target.getState();
                System.out.println(targetState);
            }

            if (targetState == State.TERMINATED) {
                interrupt();
                break;
            }
        }
    }
}
