package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/11/14 22:56
 * @description https://leetcode-cn.com/problems/detect-capital/submissions/ 520. 检测大写字母
 */
public class LeetCode520 {
    public boolean detectCapitalUse(String word) {
        if (word.length() <= 1) return true;
        boolean flag1 = Math.abs(word.charAt(0) - 'A') < 26;
        boolean flag2 = Math.abs(word.charAt(1) - 'A') < 26;
        if (!flag1 && flag2) return false;
        for (int i = 2; i < word.length(); i++) {
            boolean flag3 = Math.abs(word.charAt(i) - 'A') < 26;
            if (flag2 != flag3) return false;
        }
        return true;
    }
}
