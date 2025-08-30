package com.dsa.top.dsa_problems.java.threads;

public class ThreadLocal {
    public  int count;

    public static void main(String[] args) throws InterruptedException {
        ThreadLocal tr=new ThreadLocal();
        Runnable r1=()->{
            for(int i=0; i<10000; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" "+tr.count);
                tr.count++;
            }
        };

        Runnable r2=()->{
            for(int i=0; i<10000; i++) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+" "+tr.count);
                tr.count++;
            }
        };

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();t2.start();
        t1.join(); t2.join();
        System.out.println(tr.count);
    }

}
