package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/18 21:33
 * @description https://leetcode.cn/problems/numbers-at-most-n-given-digit-set/ 902. 最大为 N 的数字组合
 */
public class LeetCode902 {
    public int atMostNGivenDigitSet(String[] digits, int max) {
        int digitsLen = digits.length;
        int[] nums = new int[digitsLen];
        for (int i = 0; i < digitsLen; i++) {
            nums[i] = Integer.parseInt(digits[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (max != 0) {
            list.add(max % 10);
            max /= 10;
        }
        int ans = 0;
        // 统计位数少于 max 的
        for (int i = 1; i < list.size(); i++) {
            ans = ans + (int) Math.pow(digitsLen, i);
        }
        // 统计位数等于 max 的
        int listLen = list.size();
        int numsLen = nums.length;
        for (int i = listLen - 1, p = 1; i >= 0; i--, p++) {
            int cur = list.get(i);
            // 二分查找
            int left = 0, right = numsLen - 1;
            while (left < right) {
                int mid = (left + right + 1) / 2;
                if (nums[mid] <= cur) {
                    left = mid;
                } else {
                    right = mid - 1;
                }
            }
            if (nums[right] > cur) {
                break;
            } else if (nums[right] == cur) {
                ans += right * (int) Math.pow(numsLen, listLen - p);
                // 算到最后一位，如果还是相等，除了不包含该位计算以外，还得加上本身
                if (i == 0) {
                    ans++;
                }
            } else if (nums[right] < cur) {
                // 如果找到对应数 大于当前值 直接取 当前位置符合条件数 * 后续所有情况
                ans += (right + 1) * (int) Math.pow(numsLen, listLen - p);
                break;
            }
        }
        return ans;
    }
}
