package com.dsa.top.dsa_problems.java.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.TimeUnit;

class Account {
    private int balance;
    private Lock lock = new ReentrantLock();

    Account(int balance) {
        this.balance = balance;
    }

    public boolean deposit(int amount) {
        if (lock.tryLock()) {
            try {
                balance += amount;
                return true;
            } finally {
                lock.unlock();
            }
        }
        return false; // could not acquire lock
    }

    public boolean withdraw(int amount) {
        if (lock.tryLock()) {
            try {
                if (balance >= amount) {
                    balance -= amount;
                    return true;
                }
                return false;
            } finally {
                lock.unlock();
            }
        }
        return false;
    }

    public Lock getLock() { return lock; }
    public int getBalance() { return balance; }
}

public class DeadlockSolution {
    public static void main(String[] args) {
        Account acc1 = new Account(1000);
        Account acc2 = new Account(1000);

        Runnable transfer1 = () -> transfer(acc1, acc2, 500);
        Runnable transfer2 = () -> transfer(acc2, acc1, 700);

        Thread t1 = new Thread(transfer1, "T1");
        Thread t2 = new Thread(transfer2, "T2");

        t1.start();
        t2.start();
    }

    public static void transfer(Account from, Account to, int amount) {
        while (true) {
            try {
                if (from.getLock().tryLock(1, TimeUnit.SECONDS)) {
                    try {
                        if (to.getLock().tryLock(1, TimeUnit.SECONDS)) {
                            try {
                                if (from.withdraw(amount)) {
                                    to.deposit(amount);
                                    System.out.println(Thread.currentThread().getName() +
                                            " transferred " + amount);
                                }
                                break; // transfer successful, exit loop
                            } finally {
                                to.getLock().unlock();
                            }
                        }
                    } finally {
                        from.getLock().unlock();
                    }
                }
                // Could not acquire both locks, retry after a short sleep
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

