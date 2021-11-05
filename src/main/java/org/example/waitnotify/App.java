package org.example.waitnotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        Process process = new Process();

        Thread t1 = new Thread(() -> {
            try {
                process.produce();
            } catch (InterruptedException e) {
               log.error("InterruptedException occured {}", e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                process.consume();
            } catch (InterruptedException e) {
                log.error("InterruptedException occured {}", e.getMessage());
            }
        });

        t1.start();
        t2.start();
    }
}
