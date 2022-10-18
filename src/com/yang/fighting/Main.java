package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode902 proxy = new LeetCode902();
        System.out.print(proxy.atMostNGivenDigitSet(new String[]{ "3", "4", "8"}, 4));
    }

}
