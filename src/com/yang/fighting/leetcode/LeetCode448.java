package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/13 08:59
 * @description https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array/ 448. 找到所有数组中消失的数字
 */

public class LeetCode448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int len = nums.length;
        List<Integer> list = new ArrayList<>();
        if (len == 0) {
            return list;
        }
        for (int num : nums) {
            // 取模还原原来的数
            nums[(num - 1) % len] += len;
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                list.add(i + 1);
            }
        }
        return list;
    }
}
