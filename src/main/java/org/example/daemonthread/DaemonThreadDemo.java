package org.example.daemonthread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DaemonThreadDemo {

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            while(true){
                log.info("print ....");
            }
        };

        Thread thread = new Thread(task);
        thread.setDaemon(true);
        thread.start();

        log.info("Main thread finished execution....");
    }
}
