package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/12 18:30
 * @description https://leetcode.cn/problems/combination-sum/?favorite=2cktkvj 39. 组合总和
 */
public class LeetCode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(result, candidates, target, temp, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int target, List<Integer> temp, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        if (index >= candidates.length) {
            return;
        }
        if (target - candidates[index] >= 0) {
            temp.add(candidates[index]);
            dfs(result, candidates, target - candidates[index], temp, index);
            temp.remove(temp.size() - 1);
        }
        dfs(result, candidates, target, temp, index + 1);
    }
}
