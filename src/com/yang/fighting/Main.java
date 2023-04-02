package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws SocketException {
//        // write your code here
        LeetCode1039 code = new LeetCode1039();
        System.out.println(code.minScoreTriangulation(new int[] {1,3,1,4,1,5}));
    }
}
