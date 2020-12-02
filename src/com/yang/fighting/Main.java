package com.yang.fighting;

import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LeetCode321 l = new LeetCode321();
        System.out.println(Arrays.toString(l.maxNumber(new int[]{3, 4, 6, 5}, new int[]{9, 1, 2, 5, 8, 3}, 5)));
    }
}
