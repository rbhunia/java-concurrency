package org.example.threadlifecycle.blocked;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BlockedStateDemo {

    public static void main(String[] args) throws InterruptedException {
        Task task = new Task();
        Thread t1 = new Thread(task, "thread-1");
        Thread t2 = new Thread(task, "thread-2");

        t1.start();
        t2.start();
        Thread.sleep(1000);

        log.info("State of the {} is {}", t1.getName(), t1.getState());
        log.info("State of the {} is {}", t2.getName(), t2.getState());

    }

    static class Task implements Runnable {
        @Override
        public void run() {
            criticalSection();
        }

        synchronized void criticalSection() {
            while (true) {
                // some code
            }
        }
    }
}
