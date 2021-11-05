package org.example.conditionclass;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class ConditionDemo {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void method1() throws InterruptedException {
        lock.lock();
        try {
            log.info("{} processing some task...", Thread.currentThread().getName());
            Thread.sleep(2000);
            condition.await();
            log.info("{} resumed processing the task...", Thread.currentThread().getName());
        } finally {
            log.info("{} releases the lock...", Thread.currentThread().getName());
            lock.unlock();
        }
    }

    public void method2() throws InterruptedException {
        lock.lock();
        try {
            log.info("{} processing some task...", Thread.currentThread().getName());
            Thread.sleep(2000);
            condition.signal();
            log.info("{} completed processing the task...", Thread.currentThread().getName());
        } finally {
            log.info("{} releases the lock...", Thread.currentThread().getName());
            lock.unlock();
        }
    }
}
