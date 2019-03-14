package com.zhj.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger ai = new AtomicInteger(0);
    private int i = 0 ;

    public static void main(String[] args) throws InterruptedException {
        final Counter cas = new Counter();
        List<Thread> ts = new ArrayList<>(600);
        long start = System.currentTimeMillis();
        for (int j = 0; j < 100 ; j++) {
            Thread t = new Thread(()->{
                for (int k = 0; k < 10000 ; k++) {
                    cas.count();
                    cas.safeCount();
                }
            });
            ts.add(t);
        }

        for (Thread t : ts){
            t.start();
        }

        for (Thread t : ts){
            t.join();
        }

        System.out.println(cas.i);
        System.out.println(cas.ai.get());
        System.out.println(System.currentTimeMillis() - start);

    }

    private void count(){
        i++;
    }

    private void safeCount(){
        for (;;){
            int i = ai.get();
            boolean suc = ai.compareAndSet(i,++i);
            if (suc){
                break;
            }
        }
    }
}
