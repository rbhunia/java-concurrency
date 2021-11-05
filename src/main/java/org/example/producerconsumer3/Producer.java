package org.example.producerconsumer3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Producer implements Runnable {

    private Processor processor;

    public Producer(Processor processor) {
        this.processor = processor;
    }


    @Override
    public void run() {
        try {
            processor.produce();
        } catch (InterruptedException e) {
            log.error("InterruptedException occured {}", e.getMessage());
        }
    }
}
