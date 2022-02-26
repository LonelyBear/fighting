package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/2/26 11:41
 * @description https://leetcode-cn.com/problems/maximum-difference-between-increasing-elements/ 2016. 增量元素之间的最大差值
 */
public class LeetCode2016 {

    public int maximumDifference(int[] nums) {
        int res = -1;
        int tmpMin = nums[0];
        for (int num : nums) {
            if (num > tmpMin) {
                res = Math.max(res, num - tmpMin);
            }
            tmpMin = Math.min(tmpMin, num);
        }
        return res;
    }
}
