package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/20 21:46
 * @description https://leetcode-cn.com/problems/degree-of-an-array/ 697. 数组的度
 */

public class LeetCode697 {
    public int findShortestSubArray(int[] nums) {
        int[] count = new int[50000];
        for (int num : nums) {
            count[num]++;
        }
        int degree = 0;
        for (int num : count) {
            degree = Math.max(degree, num);
        }
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, Integer> numMap = new HashMap<>();
        while (right < nums.length && left <= right) {
            numSet.add(nums[right]);
            numMap.merge(nums[right], 1, Integer::sum);
            right++;
            // 其实这边可以用一个50000的数组来统计值 先增加right的值, 滑动期间再减掉左边的值
            // 每次判断对应的右值就行
            while (checkIfComputeDegree(numSet, numMap, degree)) {
                System.out.println("checkIfComputeDegree left " + left + " right " + right);
                len = Math.min(right - left, len);
                int leftValue = nums[left];
                if (numMap.get(leftValue) == 1) {
                    numMap.remove(leftValue);
                    numSet.remove(leftValue);
                } else {
                    numMap.put(leftValue, numMap.get(leftValue) - 1);
                }
                left++;
            }
        }

        return len;
    }


    private boolean checkIfComputeDegree(Set<Integer> set, Map<Integer, Integer> map, Integer degree) {
        boolean res = false;
        for (Integer num : set) {
            if (map.getOrDefault(num, 0).equals(degree)) {
                return true;
            }
        }
        return res;
    }
}
