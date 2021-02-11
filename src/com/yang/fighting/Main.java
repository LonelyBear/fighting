package com.yang.fighting;


import com.yang.fighting.leetcode.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        KthLargestV2 kthLargest = new KthLargestV2(3, new int[]{4, 5, 8, 2});
        kthLargest.add(3);   // return 4
        kthLargest.add(5);   // return 5
        kthLargest.add(10);  // return 5
        kthLargest.add(9);   // return 8
        kthLargest.add(4);   // return 8

        //"ab"
        //"eidboaoo"
    }
}
