package com.yang.fighting;


import com.yang.fighting.base.ListNode;
import com.yang.fighting.leetcode.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode1202 l = new LeetCode1202();
        //"tklkxyizmlqf"
        //[[2,10],[3,5],[8,11],[1,2],[10,6],[4,1],[1,10],[5,8],[8,3],[10,4],[7,3],[10,11]]
        l.smallestStringWithSwaps("tklkxyizmlqf", List.of(
                List.of(2, 10),
                List.of(3, 5),
                List.of(8, 11),
                List.of(1, 2),
                List.of(10, 6),
                List.of(4, 1),
                List.of(1, 10),
                List.of(5, 8),
                List.of(8, 3),
                List.of(10, 4),
                List.of(7, 3),
                List.of(10, 11)
        ));
    }
}
