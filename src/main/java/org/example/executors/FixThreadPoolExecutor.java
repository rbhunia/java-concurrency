package org.example.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixThreadPoolExecutor {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        Runnable task = () -> {
            while (true){
                if(!Thread.interrupted()){
                    System.out.println("My task");
                }else{
                    break;
                }
            }
        };

        executor.execute(task);
        Thread.sleep(5000);
        executor.shutdownNow();
    }
}
