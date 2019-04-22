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
        return counter.getAndIncrement();
    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println(" start " + Counter.get());

        int threadNums = 1000;
        CountDownLatch countDownLatch = new CountDownLatch(threadNums);
        for (int i = 0; i < threadNums; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    Counter.inc();
//                    System.out.println( Thread.currentThread().getName() + "   " +  Counter.inc() );
                }
            }, "thread-" + i).start();
            countDownLatch.countDown();
        }

        countDownLatch.await();
        System.out.println(" finished " + Counter.get());
    }

}
