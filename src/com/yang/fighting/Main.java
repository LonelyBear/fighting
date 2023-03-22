package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws SocketException {
//        // write your code here
        Leetcode64 code = new Leetcode64();
        System.out.println(code.minPathSum(new int[][] {new int[] {1,2,3}, new int[]{4,5,6}}));
    }
}
