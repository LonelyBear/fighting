package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/9/29 21:39
 * @description https://leetcode.cn/problems/string-rotation-lcci/ 面试题 01.09. 字符串轮转
 */
public class Interview0109 {
    public boolean isFlipedString(String s1, String s2) {
        return s1.length() == s2.length() && (s1 + s1).contains(s2);
    }
}
