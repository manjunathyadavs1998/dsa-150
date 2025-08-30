package com.dsa.top.dsa_problems.java.threads;

class SharedCounter {
    public int count = 0; // NOT volatile
    public boolean stop = false;
}

public class VisibilityDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedCounter counter = new SharedCounter();

        // Thread 1: increments count
        Thread t1 = new Thread(() -> {
            int local = counter.count;
            while (!counter.stop) {
                if (local != counter.count) {
                    System.out.println("Detected change: " + counter.count);
                    local = counter.count;
                }
            }
            System.out.println("Thread 1 exiting");
        });

        // Thread 2: updates stop flag after a delay
        Thread t2 = new Thread(() -> {
            try { Thread.sleep(2000); } catch (InterruptedException e) {}
            counter.count = 42;      // update count
            counter.stop = true;     // signal stop
            System.out.println("Thread 2 updated count and stop");
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("Final count: " + counter.count);
    }
}

