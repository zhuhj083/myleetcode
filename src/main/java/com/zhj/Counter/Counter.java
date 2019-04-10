package com.zhj.Counter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现一个线程安全的计数器
 *
 */
public class Counter {

    private static AtomicInteger counter = new AtomicInteger(0);

    public static int get(){
        return counter.get();
    }

    public static int inc(){
//        int oldNum = counter.get();
//        int newNum = oldNum + 1 ;
//        counter.compareAndSet(oldNum,newNum);
//        return oldNum;
        return counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {

        int threadNums = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(threadNums);

        for (int i = 0; i < threadNums; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    System.out.println( Thread.currentThread().getName() + "   " +  Counter.inc() );
                }
                countDownLatch.countDown();
            }, "thread-" + i).start();
        }

        countDownLatch.await();
        System.out.println(" finished "+Counter.get());
    }

}
