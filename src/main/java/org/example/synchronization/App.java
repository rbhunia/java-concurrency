package org.example.synchronization;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    private static int counter = 0;

    public synchronized static void increment(){
        counter++;
    }

    public static void process() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                increment();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            log.error("InterruptedException occured {}", e.getMessage());
        }

        System.out.println("The counter is : " + counter);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            process();
        }
    }
}
