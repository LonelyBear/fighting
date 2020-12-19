package com.yang.fighting.interview;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/15 21:52
 * @description
 */

public class Test20201215 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        // write your code here
        Thread mainThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                    System.out.println("mainThread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        mainThread.start();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("childThread : " + Thread.currentThread() );
                    countDownLatch.countDown();
                }
            });
            thread.start();
        }
    }
}
