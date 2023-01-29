package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/29 09:09
 * @description https://leetcode.cn/problems/count-asterisks/ 2315. 统计星号
 */
public class LeetCode2315 {
    public int countAsterisks(String s) {
        if (s.length() == 0) {
            return 0;
        }
        boolean start = false;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                if (!start) {
                    result++;
                }
            } else if (s.charAt(i) == '|') {
                start = !start;
            }
        }
        return result;
    }
}
