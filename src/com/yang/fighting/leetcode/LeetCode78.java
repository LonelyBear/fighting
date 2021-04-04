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
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < len - i; j++) {

            }
            dfs(nums, 0, i);
        }
        return null;
    }

    private void dfs(int[] nums, int cur, int count) {

    }
}
