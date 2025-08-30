package com.dsa.top.dsa_problems.java.threads;

class SharedData {
      boolean running = true;  // not volatile
    //Solution Make it Voltaile, such that variable will be availble in memory and visible to Each Thread for read
}

public class VolatileDemo {
    public static void main(String[] args) throws InterruptedException {
        SharedData data = new SharedData();

        // Thread 1: keeps running
        Thread t1 = new Thread(() -> {
            while (data.running) {
                // Looping
            }
            System.out.println("Stopped!");
        });
        t1.start();

        Thread.sleep(1000);

        // Thread 2: sets running = false
        data.running = false;
        System.out.println("Updated running to false");
    }
}
