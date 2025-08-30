package com.dsa.top.dsa_problems.java.threads;



public class DeadlockExample {
    public static void main(String[] args) {
        Account acc1 = new Account(1000);
        Account acc2 = new Account(1000);

        Thread t1 = new Thread(() -> transfer(acc1, acc2, 500), "T1");
        Thread t2 = new Thread(() -> transfer(acc2, acc1, 700), "T2");

        t1.start();
        t2.start();
    }

    public static void transfer(Account from, Account to, int amount) {
        synchronized (from.getLock()) {
            System.out.println(Thread.currentThread().getName() + " locked " + from);
            try { Thread.sleep(100); } catch (InterruptedException e) {}

            synchronized (to.getLock()) {
                System.out.println(Thread.currentThread().getName() + " locked " + to);
                from.withdraw(amount);
                to.deposit(amount);
            }
        }
    }
}

