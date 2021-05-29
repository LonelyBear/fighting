package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.function.BiFunction;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/29 23:10
 * @description 560. 和为K的子数组 https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */

public class LeetCode560 {
    public int subarraySum(int[] nums, int k) {
        int res = 0, pre = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // pre[i] - pre [j - 1] = k 则 nums[j] + ... + nums[i] == k
        // 先直当前 pre = 0
        map.put(0, 1);
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                res += map.get(pre - k);
            }
            map.merge(pre, 1, Integer::sum);
        }
        return res;
    }
}
