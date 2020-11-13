package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/28 09:06
 * @description https://leetcode-cn.com/problems/unique-number-of-occurrences/
 */

public class LeetCode1027 {
    public boolean uniqueOccurrences(int[] arr) {
        if (arr.length == 0) {
            return true;
        }
        int[] tmp = new int[2020];
        for (int i = 0; i < arr.length; i++) {
            tmp[arr[i] + 1000]++;
        }
        boolean res = true;
        Set<Integer> resSet = new HashSet<>();
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] != 0) {
                if (resSet.contains(tmp[i])) {
                    res = false;
                    break;
                }
                resSet.add(tmp[i]);
            }
        }
        return res;
    }
}
