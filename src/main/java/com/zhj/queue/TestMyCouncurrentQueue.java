package com.zhj.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestMyCouncurrentQueue {
    // 用一个原子类来获取Offer到队列中的元素个数
    static AtomicInteger count = new AtomicInteger(0);

    static MyConcurrentQueue<Integer> queue = new MyConcurrentQueue<>();

    public static void main(String[] args) {
        final int offerCount = 5;
        final int threadCount = 10;

        class Task1 implements Runnable{
            private MyConcurrentQueue<Integer> queue;
            public Task1(MyConcurrentQueue<Integer> queue) {
                this.queue = queue;
            }
            @Override
            public void run() {
                for(int i =0;i < offerCount ; i++ ) {
                    int value = count.addAndGet(1);
                    queue.offer(value);
                    System.out.println("["+Thread.currentThread()+ "]"+"offer:"+value);
                }
            }
        }

        class Task2 implements Runnable{
            private MyConcurrentQueue<Integer> queue;
            public Task2(MyConcurrentQueue<Integer> queue) {
                this.queue = queue;
            }
            @Override
            public void run() {
                while(!Thread.interrupted()) {
                    Integer value = queue.poll();
                    if(value != null) {
                        System.out.println("["+Thread.currentThread()+ "]"+"poll:"+value);
                    }
                }
            }
        }

        // 使用一个线程池来管理所有线程
        ExecutorService pool = Executors.newCachedThreadPool();
        // 分别开启了offer的线程和poll的线程
        for(int i = 0 ;i < threadCount ; i++) {
            pool.execute(new Task1(queue));
            pool.execute(new Task2(queue));
        }
        pool.shutdown();


        // 等待一段时间之后结束所有的线程
        try{
            pool.awaitTermination(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e1){
        }
        pool.shutdownNow();
    }

}
