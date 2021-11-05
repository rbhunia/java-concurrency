package org.example.synchronization;

public class SynchronizationWithCustomLock {

    private static int counter1 = 0;
    private static int counter2 = 0;

    private static final Object object1 = new Object();
    private static final Object object2 = new Object();

    private static void increment1(){
        synchronized (object1){
            for (int i = 0; i < 100; i++) {
                counter1++;
            }
        }
    }

    private static void increment2(){
        synchronized (object2){
            for (int i = 0; i < 100; i++) {
                counter2++;
            }
        }
    }

    private static void process(){
        Thread t1 = new Thread(() -> {
            increment1();
        });

        Thread t2 = new Thread(() -> {
            increment2();
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Value of count1 : " + counter1);
        System.out.println("Value of count2 : " + counter2);
    }

    public static void main(String[] args) {
        process();
    }
}
