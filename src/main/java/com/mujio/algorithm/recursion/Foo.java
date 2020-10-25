package com.mujio.algorithm.recursion;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    /**
     * 利用信号量实现顺序执行
     * 每次都要先打印0，所以将0作为控制器
     * 奇偶数方法只需关注打印
     **/
    private volatile int anInt = 1;
    Semaphore s1 = new Semaphore(1);
    Semaphore s2 = new Semaphore(0);
    Semaphore s3 = new Semaphore(0);

    private int n;

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=0; i < n; i++) {
            // 每次从0开始打印
            s1.acquire();
            printNumber.accept(0);
            // 打印完0打印奇数或偶数
            if (i%2 != 0) {
                s2.release();
            } else {
                s3.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2; i <= n; i += 2) {
            s2.acquire();
            printNumber.accept(i);
            // 打印完偶数打印0
            s1.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1; i <= n; i += 2) {
            s3.acquire();
            printNumber.accept(i);
            s1.release();
        }
    }
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(6);
        new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}