package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/21 23:03
 * @description https://leetcode.cn/problems/sort-colors/?favorite=2cktkvj 75. 颜色分类
 */
public class Leetcode75 {
    public void sortColors(int[] nums) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : nums) {
            cntMap.merge(num, 1, Integer::sum);
        }
        int iniIndex = 0;
        for (int i = 0; i < 3; i++) {
            int cnt = cntMap.getOrDefault(i, 0);
            if (cnt > 0) {
                Arrays.fill(nums, iniIndex, iniIndex + cnt, i);
                iniIndex += cnt;
            }
        }
    }
}
