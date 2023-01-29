package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @date 2023/1/20 21:04
 * @description https://leetcode.cn/problems/check-if-number-has-equal-digit-count-and-digit-value/ 2283. 判断一个数的数字计数是否等于数位的值
 */
public class LeetCode2283 {
    public boolean digitCount(String num) {
        Map<Integer, Integer> map = new HashMap<>();
        char[] array = num.toCharArray();
        for (char c : array) {
            map.merge(c - '0', 1, Integer::sum);
        }
        for (int i = 0; i < num.length(); i++) {
            if ((array[i] - '0') != map.getOrDefault(i, 0)) {
                return false;
            }
        }
        return true;
    }
}
