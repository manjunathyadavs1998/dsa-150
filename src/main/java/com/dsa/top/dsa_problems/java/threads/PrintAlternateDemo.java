package com.dsa.top.dsa_problems.java.threads;

public class PrintAlternateDemo {
    private static boolean isNum=true;
    private static final Object lock=new Object();

    public static void main(String[] args) {
        Runnable r1=()->{
            for(int i=1; i<=26; i++){
               synchronized (lock){
                   if(!isNum){
                       try {
                           lock.wait();
                       } catch (InterruptedException e) {
                           throw new RuntimeException(e);
                       }
                   }
                   System.out.print(i+" ");
                   lock.notifyAll();
                   isNum=false;
               }
            }
        };


        Runnable r2=()->{
            for(char i='A'; i<='Z'; i++){
                synchronized (lock){
                    if(isNum){
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.print(i+" ");
                    lock.notifyAll();
                    isNum=true;
                }
            }
        };

        Thread t1=new Thread(r1);
        Thread t2=new Thread(r2);
        t1.start();
        t2.start();
    }

}
