package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;

public class Main {

    public static void main(String[] args) throws SocketException {
        // write your code here
        LeetCode890 l890 = new LeetCode890();
        System.out.print(l890.findAndReplacePattern(new String[]{
                "mee"
        }, "abb"));
    }

}
