package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/9 23:28
 * @description https://leetcode-cn.com/problems/find-majority-element-lcci/ 面试题 17.10. 主要元素
 */

public class Interview1710 {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
            if (map.get(x) > n / 2) return x;
        }
        return -1;
    }
}
