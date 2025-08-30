package com.dsa.top.dsa_problems.java.threads;

import java.util.concurrent.*;
import java.util.*;

public class CallableMultiDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Thread pool of size 2
        ExecutorService executor = Executors.newFixedThreadPool(2);

        // List to hold Future objects
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit 10 tasks
        for (int i = 1; i <= 10; i++) {
            int taskId = i;
            Callable<Integer> task = () -> {
                System.out.println("Task " + taskId + " running on: " + Thread.currentThread().getName());
                int sum = 0;
                for (int j = 1; j <= 5; j++) {
                    sum += j;
                    Thread.sleep(100); // simulate work
                }
                return sum;
            };
            futures.add(executor.submit(task));
        }

        // Get results
        for (int i = 0; i < futures.size(); i++) {
            System.out.println("Result of Task " + (i+1) + " = " + futures.get(i).get());
        }

        executor.shutdown();
    }
}

