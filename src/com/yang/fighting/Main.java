package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode31 proxy = new LeetCode31();
        int[] nums = new int[]{1, 2, 3};
        proxy.nextPermutation(nums);
        System.out.print(Arrays.toString(nums));
    }

}
