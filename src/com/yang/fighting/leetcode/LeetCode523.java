package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/2 16:13
 * @description https://leetcode-cn.com/problems/continuous-subarray-sum/ 523. 连续的子数组和
 */

public class LeetCode523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int sumTmp = 0;
        map.put(0, -1);
         // 前缀和 + (array[i] - array[j]) % k == 0 等价于 array[i] % k == array[j] % k
        for (int i = 0; i < nums.length; i++) {
            sumTmp += nums[i];
            if (map.containsKey(sumTmp % k)) {
                if (i - map.get(sumTmp % k) >= 2) {
                    return true;
                }
            } else {
                map.put(sumTmp % k, i);
            }
        }
        return false;
    }
}
