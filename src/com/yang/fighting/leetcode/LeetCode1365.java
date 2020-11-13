package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/26 18:32
 * @description https://leetcode-cn.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */

public class LeetCode1365 {

    int[] count = new int[101];
    int[] rank = new int[101];

    public int[] smallerNumbersThanCurrent(int[] nums) {
        if (nums.length == 0) {
            return new int[0];
        }
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 1; i < 101; i++) {
            rank[i] = rank[i - 1] + count[i - 1];
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = rank[nums[i]];
        }
        return res;
    }
}
