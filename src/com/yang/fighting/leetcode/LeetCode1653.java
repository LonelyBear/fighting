package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/6 22:00
 * @description https://leetcode.cn/problems/minimum-deletions-to-make-string-balanced/ 1653. 使字符串平衡的最少删除次数
 */
public class LeetCode1653 {
    public int minimumDeletions(String s) {
        int leftB = 0, rightA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                rightA++;
            }
        }
        int ans = rightA;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                rightA--;
            } else {
                leftB++;
            }
            ans = Math.min(ans, leftB + rightA);
        }
        return ans;
    }
}
