package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/8 16:49
 * @description https://leetcode-cn.com/problems/binary-subarrays-with-sum/ 930. 和相同的二元子数组
 */

public class LeetCode930 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
        numList.add(0);
        countMap.put(0, 1);
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            if (countMap.containsKey(prefixSum)) {
                countMap.put(prefixSum, countMap.get(prefixSum) + 1);
            } else {
                countMap.put(prefixSum, 1);
                numList.add(prefixSum);
            }
        }
        int result = 0;
        for (int num : numList) {
            int other = num - goal;
            if (countMap.containsKey(other)) {
                if (num == other) {
                    result += calc(countMap.get(num) - 1);
                } else {
                    result += countMap.get(num) * countMap.get(other);
                }
            }
        }
        return result;
    }

    private int calc(int num) {
        if (num == 0) return 0;
        return num + calc(num - 1);
    }
}
