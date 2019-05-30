package thread.control;

import java.util.concurrent.*;

public class SynchronizedThread{

    private int sum = 0;

    public synchronized void increment(){
        System.out.println(Thread.currentThread().getName()+": "+(sum++));
    }

    public static void main(String[] args){
        SynchronizedThread thread1 = new SynchronizedThread();
        for(int i=0; i<100; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    thread1.increment();
                }
            }, "第" + i + "个线程").start();
        }
    }
}
