package com.dsa.top.dsa_problems.java.threads;

public class ThreadCycle {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Running");
        });
        System.out.println(t.getState()); // NEW

        t.start();
        System.out.println(t.getState());

    }
}
