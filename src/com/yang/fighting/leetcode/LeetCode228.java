package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/10 16:50
 * @description
 */

public class LeetCode228 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return new ArrayList<>(2);
        }
        List<String> res = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1] + 1) {
                if (start == end) {
                    res.add(String.valueOf(nums[start]));
                } else {
                    res.add(nums[start] + "->" + nums[end]);
                }
                start = i;
            }
            end = i;
        }
        if (start == end) {
            res.add(String.valueOf(nums[start]));
        } else {
            res.add(nums[start] + "->" + nums[end]);
        }
        return res;
    }
}
