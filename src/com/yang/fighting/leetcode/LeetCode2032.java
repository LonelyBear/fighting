package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @date 2023/1/27 13:43
 * @description https://leetcode.cn/problems/two-out-of-three/ 2032. 至少在两个数组中出现的值
 */
public class LeetCode2032 {
    public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] values = new int[101];
        process(nums1, values);
        process(nums2, values);
        process(nums3, values);
        return transResult(values);
    }

    private void process(int[] nums, int[] values) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                values[num]++;
            }
            set.add(num);
        }
    }

    private List<Integer> transResult(int[] values) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] > 1) {
                list.add(i);
            }
        }
        return list;
    }
}
