package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/6 22:15
 * @description https://leetcode.cn/problems/permutations/?favorite=2cktkvj 46. 全排列
 */
public class LeetCode46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> indexSet = new HashSet<>();
            indexSet.add(i);
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            dfs(result, indexSet, nums, list, i);
        }
        return result;
    }

    private void dfs(List<List<Integer>> result, Set<Integer> indexSet, int[] nums, List<Integer> list, int iniIndex) {
        if (indexSet.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (indexSet.contains(i) || iniIndex == i) {
                continue;
            }
            indexSet.add(i);
            list.add(nums[i]);
            dfs(result, indexSet, nums, list, iniIndex);
            indexSet.remove(i);
            list.remove(list.size() - 1);
        }
    }
}
