package com.dsa.top.dsa_problems.java.threads;

import java.util.concurrent.atomic.AtomicInteger;

class CounterVolatile {
    private AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();   // NOT atomic
    }

    public void decrement() {
       count.decrementAndGet();   // NOT atomic
    }

    public int getCount() {
        return count.get();
    }
}

public class TestVolatile {
    public static void main(String[] args) throws InterruptedException {
        CounterVolatile counter = new CounterVolatile();

        Runnable task1 = () -> {
            for (int i = 0; i < 100000; i++) {
                counter.increment();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 100000; i++) {
                counter.decrement();
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);

        t1.start(); t2.start();
        t1.join();  t2.join();

        System.out.println("Final count = " + counter.getCount());
    }
}

