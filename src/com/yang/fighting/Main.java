package com.yang.fighting;


import com.yang.fighting.leetcode.LeetCode218;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        LeetCode218 l = new LeetCode218();
        l.getSkyline(new int[][]{new int[] {2 , 9 , 10},
                new int[] {3 , 7 , 15},
                new int[] {5 , 12 , 12},
                new int[] {15 , 20 , 10},
                new int[] {19 , 24 , 8}});
    }
}
