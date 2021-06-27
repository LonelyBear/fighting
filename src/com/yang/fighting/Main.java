package com.yang.fighting;


import com.yang.fighting.base.Employee;
import com.yang.fighting.base.ListNode;
import com.yang.fighting.base.TreeNode;
import com.yang.fighting.leetcode.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode909 l = new LeetCode909();
        int[][] b = new int[][]{{-1,1,2,-1},
                {2,13,15,-1},
                {-1,10,-1,-1},
                {-1,6,2,8}};
        // [[-1,1,2,-1],[2,13,15,-1],[-1,10,-1,-1],[-1,6,2,8]]
        l.snakesAndLadders(b);
    }
}
