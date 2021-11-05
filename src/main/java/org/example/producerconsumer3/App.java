package org.example.producerconsumer3;

// Producer consumer using Lock and Condition
public class App {

    public static void main(String[] args) {
        Processor processor = new Processor();

        Thread producer = new Thread(new Producer(processor));
        Thread consumer = new Thread(new Consumer(processor));

        producer.start();
        consumer.start();
    }
}
