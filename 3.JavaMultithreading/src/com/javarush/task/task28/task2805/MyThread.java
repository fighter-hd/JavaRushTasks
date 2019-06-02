package com.javarush.task.task28.task2805;

public class MyThread extends Thread {
    private int countOfThread = 1;
    private static int priority = 1;
    private ThreadGroup currentThGroup = getThreadGroup();

//    private static void customSetPriority(Thread currentThread, ThreadGroup currentThGroup) {
//        if (priority == currentThGroup.getMaxPriority()) {
//            currentThread.setPriority(currentThGroup.getMaxPriority());
//            priority = 1;
//            return;
//        }
//
//        currentThread.setPriority(priority++);
//    }

    {
        setPriority(priority++);

        if (priority > 10) {
            priority = 1;
        }
    }

    public MyThread() {
//        customSetPriority(this, this.getThreadGroup());
    }

    public MyThread(Runnable target) {
        super(target);
//        customSetPriority(this, this.getThreadGroup());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
//        customSetPriority(this, group);
    }

    public MyThread(String name) {
        super(name);
//        customSetPriority(this, this.getThreadGroup());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
//        customSetPriority(this, group);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
//        customSetPriority(this, this.getThreadGroup());
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
//        customSetPriority(this, group);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
//        customSetPriority(this, group);
    }
}
