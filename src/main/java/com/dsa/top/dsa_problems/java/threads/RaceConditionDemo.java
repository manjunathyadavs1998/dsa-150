package com.dsa.top.dsa_problems.java.threads;


class Bank{
    private int bal;
    Bank(int bal){
        this.bal=bal;
    }
    public  synchronized void increment(){
        bal++;
    }
    public synchronized void  decrement(){
        bal--;
    }

    public int getBal(){
        return bal;
    }
}
public class RaceConditionDemo {
    public static void main(String[] args) throws InterruptedException {
        Bank b=new Bank(100);
        Runnable r1=()->{
            for(int i=0; i<100000; i++) {
                b.increment();
            }
        };
        Runnable r2=()->{
            for(int i=0; i<100000; i++) b.decrement();
        };
        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(b.getBal());
    }
}
