package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode915 proxy = new LeetCode915();
        proxy.partitionDisjoint(new int[]{5, 0, 3, 8, 6});
    }

}
