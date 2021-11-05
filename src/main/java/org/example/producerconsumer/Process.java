package org.example.producerconsumer;

import java.util.ArrayList;
import java.util.List;

public class Process {

    private static final List<Integer> list = new ArrayList<>();

    private static final int UPPER_LIMIT = 5;
    private static final int LOWER_LIMIT = 0;

    private static final Object lock = new Object();

    private int counter = 0;

    public void produce() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == UPPER_LIMIT) {
                    counter = 0;
                    System.out.println("Waiting for removing items from the list ....");
                    lock.wait();
                } else {
                    System.out.println("Adding value : " + counter);
                    list.add(counter);
                    counter++;
                    lock.notify();
                }

                Thread.sleep(500);
            }
        }
    }

    public void consume() throws InterruptedException {
        synchronized (lock) {
            while (true) {
                if (list.size() == LOWER_LIMIT) {
                    System.out.println("Waiting for adding items into the list ....");
                    lock.wait();
                } else {
                    System.out.println("Removing value : " + list.remove(list.size() - 1));
                    lock.notify();
                }
                Thread.sleep(500);
            }
        }
    }
}
