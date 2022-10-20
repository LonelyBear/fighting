package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode779 proxy = new LeetCode779();
        System.out.print(proxy.kthGrammar(1, 1));
        System.out.print("\n");
        System.out.print(proxy.kthGrammar(2, 1));
        System.out.print("\n");
        System.out.print(proxy.kthGrammar(2, 2));
        System.out.print("\n");
        System.out.print(proxy.kthGrammar(3, 4));
        System.out.print("\n");
        System.out.print(proxy.kthGrammar(4, 6));
        System.out.print("\n");
        System.out.print(proxy.kthGrammar(5, 16));
        System.out.print("\n");
    }

}
