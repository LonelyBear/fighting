package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/11/20 17:22
 * @description https://leetcode-cn.com/problems/longest-harmonious-subsequence/ 594. 最长和谐子序列
 */
public class LeetCode594 {
    public int findLHS(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        Set<Integer> numSet = new HashSet<>();
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            numSet.add(num);
            countMap.merge(num, 1, Integer::sum);
        }
        if (numSet.size() <= 1) {
            return 0;
        }
        List<Integer> numList = new ArrayList<>(numSet);
        Collections.sort(numList);
        int res = 0;
        for (int i = 0; i < numList.size() - 1; i++) {
            if (!countMap.containsKey(numList.get(i) + 1)) {
                continue;
            }
            res = Math.max(res, countMap.get(numList.get(i)) + countMap.get(numList.get(i + 1)));
        }
        return res;
    }
}
