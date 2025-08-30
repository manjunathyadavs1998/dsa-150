package com.dsa.top.dsa_problems.java.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    private int count = 0;
    private final Lock lock = new ReentrantLock();

    public void increment() {
        lock.lock();       // acquire the lock
        try {
            count++;
        } finally {
            lock.unlock(); // always release in finally
        }
    }

    public int getCount() {
        return count;
    }
}

public class ReentrantLockDemo {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Runnable task = () -> {
            for (int i = 0; i < 100000; i++) counter.increment();
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);
        t1.start(); t2.start();
        t1.join(); t2.join();

        System.out.println("Final count = " + counter.getCount());
    }
}
