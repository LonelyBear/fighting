package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode15 proxy = new LeetCode15();
        System.out.print(proxy.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

}
