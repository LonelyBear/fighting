package com.yang.fighting;

import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        LeetCode74 l = new LeetCode74();
        int[][] matrix = new int[][]{{1},{3}};
        System.out.println(l.searchMatrix(matrix , 3));
    }
}
