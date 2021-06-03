package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/3 14:40
 * @description https://leetcode-cn.com/problems/contiguous-array/ 525. 连续数组
 */

public class LeetCode525 {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        int[] array = new int[len];
        array[0] = (nums[0] == 0 ? -1 : 1);
        for (int i = 1; i < len; i++) {
            array[i] = array[i - 1] + (nums[i] == 0 ? -1 : 1);
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            if (indexMap.containsKey(array[i])) {
                res = Math.max(res, i - indexMap.get(array[i]));
            } else {
                indexMap.put(array[i], i);
            }
        }
        return res;
    }
}
