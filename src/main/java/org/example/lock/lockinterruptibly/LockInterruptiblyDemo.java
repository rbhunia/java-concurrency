package org.example.lock.lockinterruptibly;

public class LockInterruptiblyDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            counter.increaseCount();
        }, "t1");

        Thread t2 = new Thread(() -> {
            counter.increaseCount();
        }, "t2");

        t1.start();
        t2.start();

        //Thread.sleep(2000);

        t1.interrupt();

        //Thread.sleep(2000);

        t2.interrupt();
    }
}
