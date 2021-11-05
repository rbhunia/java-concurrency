package org.example.lock.lockinterruptibly;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Counter {

    private int counter = 0;

    private Lock lock = new ReentrantLock();

    public void increaseCount() {
        while (true) {
            try {
                lock.lockInterruptibly();
                System.out.println(Thread.currentThread().getName() + " is holding the lock....");
                Thread.sleep(200);
                counter++;
                System.out.println(Thread.currentThread().getName() + " has increased the counter to " + counter);
                lock.unlock();
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted....");
            }
//            finally {
//                System.out.println("Calling finally");
//                lock.unlock();
//            }
        }
    }
}
