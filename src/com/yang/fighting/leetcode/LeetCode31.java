package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/10 10:25
 * @description https://leetcode-cn.com/problems/next-permutation/ 31. 下一个排列
 */

public class LeetCode31 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }
        int i = nums.length - 2;
        // 找到第一个 升序的 i
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            // 找到右边区间比i第一个大的数进行交换
            int tmp = nums[j];
            nums[j] = nums[i];
            nums[i] = tmp;
        }
        // 对后续交换的数组进行排序
        Arrays.sort(nums, i + 1, nums.length);
    }

}
