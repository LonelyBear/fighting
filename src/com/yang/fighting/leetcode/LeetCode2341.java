package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/16 21:01
 * @description https://leetcode.cn/problems/maximum-number-of-pairs-in-array/ 2341. 数组能形成多少数对
 */
public class LeetCode2341 {
    public int[] numberOfPairs(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.merge(num, 1, Integer::sum);
        }
        int[] ans = new int[2];
        for (Map.Entry<Integer, Integer> entry : cntMap.entrySet()) {
            int val = entry.getValue();
            ans[0] += val / 2;
            ans[1] += val % 2;
        }
        return ans;
    }
}
