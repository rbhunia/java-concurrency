package org.example.waitnotify;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Process {

    public void produce() throws InterruptedException{
        synchronized (this){
            log.info("Started producing... ");
            this.wait();
            log.info("Execute after notify....");
        }
    }

    public void consume() throws InterruptedException{
        synchronized (this){
            log.info("Started consuming... ");
            this.notify();
            log.info("Finished consuming....");
        }
    }
}
