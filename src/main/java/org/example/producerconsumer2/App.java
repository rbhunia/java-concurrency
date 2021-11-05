package org.example.producerconsumer2;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {

    private static final int MAX_CAPACITY = 10;

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Item> blockingQueue = new ArrayBlockingQueue<>(MAX_CAPACITY);

        Runnable producer = () -> {
            while (true) {
                int data = new Random().nextInt();
                System.out.println("Adding " + data + " in the queue.");
                Item item = new Item(data);
                if (blockingQueue.size() != MAX_CAPACITY) {
                    blockingQueue.add(item);
                }
            }
        };

        Runnable consumer = () -> {
            while (true) {
                try {
                    Item item = blockingQueue.take();
                    item.process();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        new Thread(producer).start();
        new Thread(producer).start();

        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(1000);
    }
}
