package com.dsa.top.dsa_problems.java.threads;

import java.util.List;
import java.util.concurrent.Callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 1. Create ExecutorService
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // 2. Create Callable task
        Callable<Integer> task = () -> {
            int sum = 0;
            System.out.println(Thread.currentThread().getName());
            for (int i = 1; i <= 5; i++) {
                sum += i;
            }
            return sum; // returning value
        };

        Future<Integer> future1 = executor.submit(task);
        Future<Integer> future2 = executor.submit(task);

        System.out.println("Result1 = " + future1.get());
        System.out.println("Result2 = " + future2.get());

        executor.shutdown();
    }
}

