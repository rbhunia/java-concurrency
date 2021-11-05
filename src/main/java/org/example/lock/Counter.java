package org.example.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int counter = 0;

    private Lock lock = new ReentrantLock();

    public void increaseCount() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " is holding the lock....");
            counter++;
            System.out.println(Thread.currentThread().getName() + " has increased the counter to " + counter);
        } finally {
            lock.unlock();
        }
//        System.out.println(Thread.currentThread().getName() + " is holding the lock....");
//        counter++;
//        someTask();
//        lock.unlock();
    }

//    static void someTask() {
//        throw new RuntimeException("This is a runtime exception");
//    }
}
