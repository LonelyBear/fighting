package com.yang.fighting.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/29 12:00
 * @description https://leetcode-cn.com/problems/print-zero-even-odd/
 */

public class ZeroEvenOdd {

    private int n;
    private Semaphore zeroS = new Semaphore(1);
    private Semaphore evenS = new Semaphore(0);
    private Semaphore oddS = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 0; i < n; i++){
            zeroS.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                oddS.release();
            } else {
                evenS.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= n; i += 2){
            evenS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }


    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n; i += 2){
            oddS.acquire();
            printNumber.accept(i);
            zeroS.release();
        }
    }
}
