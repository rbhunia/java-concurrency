package org.example.producerconsumer3;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Processor {

    private List<Integer> buffer = new ArrayList<>();
    private Lock lock = new ReentrantLock();
    private static final int MAX_SIZE = 5;

    private final Condition bufferNotFullCondition = lock.newCondition();
    private final Condition bufferNotEmptyCondition = lock.newCondition();

    public void produce() throws InterruptedException{
        lock.lock();
        try{
            while (true){
                while (buffer.size() == MAX_SIZE){
                    log.info("Buffer is full. Let's wait...");
                    bufferNotFullCondition.await();
                }
                int data = new Random().nextInt();
                if (buffer.add(data)){
                    log.debug("Buffer is not empty and data {} is added to the buffer....", data);
                    Thread.sleep(1000);
                    bufferNotEmptyCondition.signalAll();
                }
            }
        }finally {
            lock.unlock();
        }
    }

    public void consume() throws InterruptedException{
        lock.lock();
        try{
            while (true){
                while (buffer.size() == 0){
                    log.info("Buffer is empty. Let's wait...");
                    bufferNotEmptyCondition.await();
                }
                int removedData = buffer.remove(buffer.size() - 1);
                log.debug("{} removed from the buffer..", removedData);
                Thread.sleep(1000);
                bufferNotFullCondition.signalAll();
            }
        }finally {
            lock.unlock();
        }
    }
}
