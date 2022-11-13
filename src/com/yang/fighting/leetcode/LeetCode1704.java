package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/11 21:33
 * @description https://leetcode.cn/problems/determine-if-string-halves-are-alike/ 1704. 判断字符串的两半是否相似
 */
public class LeetCode1704 {

    private final Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public boolean halvesAreAlike(String s) {
        int left = 0, right = s.length() - 1, leftCnt = 0, rightCnt = 0;
        while (left <= right) {
            if (set.contains(s.charAt(left++))) {
                leftCnt++;
            }
            if (set.contains(s.charAt(right--))) {
                rightCnt++;
            }
        }
        return leftCnt == rightCnt;
    }
}
