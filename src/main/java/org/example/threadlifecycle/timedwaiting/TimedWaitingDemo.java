package org.example.threadlifecycle.timedwaiting;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimedWaitingDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            while (true) {
                // some code
            }
        };

        Runnable task2 = () -> {
            Thread thread = new Thread(task1, "thread-1");
            thread.start();
            try {
                thread.join(2000);
            } catch (InterruptedException e) {
                log.error("Interrupted exception occured {}", e.getMessage());
            }
        };

        Thread thread = new Thread(task2, "thread-2");
        thread.start();

        Thread.sleep(1000);
        log.info("{}", thread.getState());
    }
}
