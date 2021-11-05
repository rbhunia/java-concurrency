package org.example.lock.reentrantreadwritelock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);

        Cache cache = new Cache();

        for (int i = 0; i < 4; i++) {
            executor.submit(new Task(cache));
        }
    }
}
