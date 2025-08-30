package com.dsa.top.dsa_problems.java.threads;

class Resource{

    String resource;
    Resource(String s){
        this.resource=s;
    }
}

public class DeadLockDemo {
    public static void main(String[] args) {
        Resource r1=new Resource("R1");
        Resource r2=new Resource("R2");

        Runnable run1=()->{
            synchronized (r1){
                System.out.println("Thread 1 calling");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (r2){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };


        Runnable run2=()->{
            System.out.println("Thread 2 calling");
            synchronized (r1){
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (r2){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };

        Thread t1=new Thread(run1);
        Thread t2=new Thread(run2);
        t1.start();
        t2.start();
    }



}
