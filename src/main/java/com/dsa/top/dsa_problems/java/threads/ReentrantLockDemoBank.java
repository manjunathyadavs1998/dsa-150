package com.dsa.top.dsa_problems.java.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int balance = 1000;
    Lock lock = new ReentrantLock(true);  // fair lock
    private Condition sufficientFunds = lock.newCondition();

    // Deposit money
    public void deposit(int amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount + " | Balance: " + balance);
            sufficientFunds.signalAll(); // notify waiting threads
        } finally {
            lock.unlock();
        }
    }

    // Withdraw money (wait if insufficient)
    public void withdraw(int amount) throws InterruptedException {
        lock.lock();
        try {
            while (balance < amount) {
                System.out.println(Thread.currentThread().getName() + " waiting to withdraw: " + amount);
                sufficientFunds.await();  // wait for deposit
            }
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + " | Balance: " + balance);
        } finally {
            lock.unlock();
        }
    }

    public int getBalance() {
        return balance;
    }
}

public class ReentrantLockDemoBank {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        Runnable depositor = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(500);
                try { Thread.sleep(200); } catch (InterruptedException e) {}
            }
        };

        Runnable withdrawer = () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    if (account.lock.tryLock()) {  // try to acquire lock without waiting
                        try {
                            account.withdraw(700);
                        } finally {
                            account.lock.unlock();
                        }
                    } else {
                        System.out.println(Thread.currentThread().getName() + " could not acquire lock, skipping withdraw");
                    }
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread t1 = new Thread(depositor, "Depositor-1");
        Thread t2 = new Thread(withdrawer, "Withdrawer-1");
        Thread t3 = new Thread(withdrawer, "Withdrawer-2");

        t1.start(); t2.start(); t3.start();
    }
}

