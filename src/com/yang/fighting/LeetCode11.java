package com.yang.fighting;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/29 17:22
 * @description https://leetcode-cn.com/problems/container-with-most-water/
 */

public class LeetCode11 {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int res = 0;
        while (left < right) {
            res = Math.max(res, Math.min(height[left], height[right]) * (right - left));
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return res;
    }
}
