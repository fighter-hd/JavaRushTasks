package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj2) {
            synchronized (obj1) {
//                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        //создаём 2 потока.
        // В первом потоке берём мьютекс "о1" и ждём что бы дать возможность
        // другому потоку попробовать войти в свой synchronized блок.
        // Потом занимаем мьютекс "о2" что бы в случае когда второй блок займёт
        //свой первый мьютекс возник DeadLock
        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    o1.wait();
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) { }
            }
        });

        //Второй поток просто вызывает нужный метод где и будет занимать
        //соответсвующие мьютексы
        Thread t2 = new Thread(() -> solution.someMethodWithSynchronizedBlocks(o1, o2));

        //Обеспечиваем запуск нитей так что бы первая нить в любом случае
        //успела занять свой первый мьютекс
        t1.start();
        Thread.sleep(5);
        t2.start();

        //Даём время нитям друг-друга заблокировать если параметры
        //переданы не в нужном порядке или отработать им до конца.
        Thread.sleep(2050);

        //Если DeadLock не произошёл, то вторая нить успеет закончить работу.
        //Если DeadLock возник, то вторая нить будет заблокированаю.
        //Соответственно обрабатываем оба случая
        if (t2.getState() != Thread.State.BLOCKED) {
            return true;
        } else {
            //Программа зависает даже если подгадать момент что бы
            //первая нить прерывалась.
            t1.interrupt();
            t2.interrupt();
            return false;
        }

//        System.out.println("State t1: " + t1.getState());
//        System.out.println("State t2: " + t2.getState());
//        return false;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
