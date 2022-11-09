package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode764 proxy = new LeetCode764();
        System.out.print(proxy.orderOfLargestPlusSign(5, new int[][]{{4, 2}}));


    }
}
