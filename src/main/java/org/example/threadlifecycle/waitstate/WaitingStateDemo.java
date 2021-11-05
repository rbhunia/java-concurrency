package org.example.threadlifecycle.waitstate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WaitingStateDemo {

    public static void main(String[] args) throws InterruptedException {

        Runnable task1 = () -> {
            while (true) {
                //
            }
        };

        Runnable task2 = () -> {
            Thread thread = new Thread(task1);
            thread.start();
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread thread = new Thread(task2);
        thread.start();

        Thread.sleep(2000); // we wait for some time so that thread goes to waiting state
        log.info("{}", thread.getState());
    }
}
