package org.example.conditionclass;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class App {

    public static void main(String[] args) {
        ConditionDemo conditionDemo = new ConditionDemo();

        Runnable task1 = () -> {
            try {
                conditionDemo.method1();
            } catch (InterruptedException e) {
                log.error("InterruptedException occured {}", e.getMessage());
            }
        };

        Runnable task2 = () -> {
            try {
                conditionDemo.method2();
            } catch (InterruptedException e) {
                log.error("InterruptedException occured {}", e.getMessage());
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start();
        t2.start();
    }
}
