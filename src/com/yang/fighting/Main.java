package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws SocketException {
//        // write your code here
//        LeetCode1801 proxy = new LeetCode1801();
//        // [[26,7,0],[16,1,1],[14,20,0],[23,15,1],[24,26,0],[19,4,1],[1,1,0]]
//        System.out.print(proxy.getNumberOfBacklogOrders(
//                        new int[][]{
//                                new int[]{26, 7, 0},
//                                new int[]{16, 1, 1},
//                                new int[]{14, 20, 0},
//                                new int[]{23, 15, 1},
//                                new int[]{24, 26, 0},
//                                new int[]{19, 4, 1},
//                                new int[]{1, 1, 0}
//                        }
//                )
//        );
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa", 1);
        authenticationManager.generate("aaa", 2);
        authenticationManager.countUnexpiredTokens(6);
        authenticationManager.generate("bbb", 7);
        authenticationManager.renew("aaa", 8);
        authenticationManager.renew("bbb", 10);
        authenticationManager.countUnexpiredTokens(15);

    }
}
