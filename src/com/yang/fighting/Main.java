package com.yang.fighting;


import com.yang.fighting.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode830 l = new LeetCode830();
        Class clazz = l.getClass();
        Object[] objects = clazz.getFields();
        System.out.println(l.largeGroupPositions("abcdddeeeeaabbbcd"));
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("122121");
            }
        });
        thread.start();

        System.out.println(Arrays.toString(objects));
    }
}
