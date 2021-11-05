package org.example.lock.reentrant;

public class ReentrantLockDemo {

    public static void main(String[] args) {
        Task task = new Task(5);
        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();
    }
}
