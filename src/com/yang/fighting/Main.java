package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode904 proxy = new LeetCode904();
        System.out.print(proxy.totalFruit(new int[]{3,3,3,1,2,1,1,2,3,3,4}));
    }

}
