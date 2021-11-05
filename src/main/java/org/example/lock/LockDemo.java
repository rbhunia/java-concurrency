package org.example.lock;

public class LockDemo {

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.increaseCount();
        }, "t1");

        Thread t2 = new Thread(() -> {
            counter.increaseCount();
        }, "t2");

        t1.start();
        t2.start();
    }
}
