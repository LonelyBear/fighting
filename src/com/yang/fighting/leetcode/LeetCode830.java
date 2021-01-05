package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/5 13:01
 * @description https://leetcode-cn.com/problems/positions-of-large-groups/ 830. 较大分组的位置
 */

public class LeetCode830 {
    public List<List<Integer>> largeGroupPositions(String s) {
        if (s.length() <= 1) {
            return new ArrayList<>(2);
        }
        List<List<Integer>> res = new ArrayList<>();
        int left = 0;
        int right = 1;
        while (right < s.length()) {
            if (s.charAt(right) == s.charAt(left)) {
                right++;
            } else {
                if (right - left >= 3) {
                    res.add(Arrays.asList(left, right - 1));
                }
                left = right;
                right++;
            }
        }
        // 判断最后一组
        if (s.charAt(right - 1) == s.charAt(left)) {
            if (right - left >= 3) {
                res.add(Arrays.asList(left, right - 1));
            }
        }
        return res;
    }
}
