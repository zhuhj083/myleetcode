package com.zhj.test;

import java.util.concurrent.Semaphore;

/**
 * Semaphore又称信号量，是操作系统中的一个概念，在Java并发编程中，信号量控制的是线程并发的数量。
 *
 * public Semaphore(int permits);
 * 其中参数permits就是允许同时运行的线程数目;
 *
 * Semaphore semaphore = new Semaphore(10,true);
 * semaphore.acquire();
 * //do something here
 * semaphore.release();
 */
public class ThreadABC_Semaphore {

    private static Semaphore A = new Semaphore(1);
    private static Semaphore B = new Semaphore(0);
    private static Semaphore C = new Semaphore(0);

    static class ThreadA extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    A.acquire();
                    System.out.print("A");
                    B.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ThreadB extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    B.acquire();
                    System.out.print("B");
                    C.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class ThreadC extends Thread{
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    C.acquire();
                    System.out.print("C");
                    A.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread a = new ThreadA();
        Thread b = new ThreadB();
        Thread c = new ThreadC();
        a.start();
        c.start();
        b.start();
    }

}
