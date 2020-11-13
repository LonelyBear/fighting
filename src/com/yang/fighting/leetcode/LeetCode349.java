package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/2 10:20
 * @description https://leetcode-cn.com/problems/intersection-of-two-arrays/
 */

public class LeetCode349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for (int j : nums1) {
            set1.add(j);
        }
        for (int j : nums2) {
            set2.add(j);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer e : set1) {
            if (set2.contains(e)) {
                list.add(e);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
