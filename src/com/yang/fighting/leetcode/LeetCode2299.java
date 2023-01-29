package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @date 2023/1/19 09:30
 * @description https://leetcode.cn/problems/strong-password-checker-ii/ 2299. 强密码检验器 II
 */
public class LeetCode2299 {

    private final static Set<Character> SPECIAL_CHAR_SET = new HashSet<>(Arrays.asList('!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '+'));

    public boolean strongPasswordCheckerII(String password) {
        if (password.length() < 8) {
            return false;
        }
        boolean hasSmallChar = false;
        boolean hasBigChar = false;
        boolean hasNumber = false;
        boolean hasSpecialChar = false;
        Character lastChar = null;
        for (char c : password.toCharArray()) {
            if (lastChar != null && lastChar == c) {
                return false;
            }
            if (c >= '0' && c <= '9') {
                hasNumber = true;
            } else if (c >= 'a' && c <= 'z') {
                hasSmallChar = true;
            } else if (c >= 'A' && c <= 'Z') {
                hasBigChar = true;
            } else if (SPECIAL_CHAR_SET.contains(c)) {
                hasSpecialChar = true;
            }
            lastChar = c;
        }
        return hasSmallChar && hasBigChar && hasNumber && hasSpecialChar;
    }
}
