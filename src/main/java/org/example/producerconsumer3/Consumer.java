package org.example.producerconsumer3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Consumer implements Runnable{
    private Processor processor;

    public Consumer(Processor processor) {
        this.processor = processor;
    }

    @Override
    public void run() {
        try {
            processor.consume();
        } catch (InterruptedException e) {
            log.error("InterruptedException occured {}", e.getMessage());
        }
    }
}
