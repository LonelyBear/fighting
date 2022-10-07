package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode1800 proxy = new LeetCode1800();
        System.out.print(proxy.maxAscendingSum(new int[]{12, 17, 15, 13, 10, 11, 12}));
    }

}
