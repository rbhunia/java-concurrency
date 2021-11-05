package org.example.lock.reentrant;

import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class Task implements Runnable {

    private int number;

    private ReentrantLock lock = new ReentrantLock();

    public Task(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        log.info("Factorial of number {} is {}", number, factorial(number));
    }

    private BigDecimal factorial(int number) {
        lock.lock();
        log.debug("Hold count after acquiring the lock {}", lock.getHoldCount());
        try {
            if (number == 0 || number == 1)
                return BigDecimal.ONE;
            else {
                return factorial(number - 1).multiply(BigDecimal.valueOf(number));
            }
        } finally {
            lock.unlock();
            log.debug("Hold count after releasing the lock {}", lock.getHoldCount());
        }
    }
}
