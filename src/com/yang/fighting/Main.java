package com.yang.fighting;

import com.yang.fighting.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LeetCode283 leetCode283 = new LeetCode283();
        int[] input = new int[]{0, 1, 0, 3, 12};
        leetCode283.moveZeroes(input);
        System.out.println(Arrays.toString(input));
    }
}
