package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/31 15:48
 * @description https://leetcode-cn.com/problems/subsets/ 78. 子集
 */

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        dfs(result, list, nums, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result,
                     List<Integer> list,
                     int[] nums,
                     int index) {
        if (index == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        dfs(result, list, nums, index + 1);
        list.remove(list.size() - 1);
        dfs(result, list, nums, index + 1);
    }


}
