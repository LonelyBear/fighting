package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/9/27 22:00
 * @description https://leetcode.cn/problems/check-permutation-lcci/ 面试题 01.02. 判定是否互为字符重排
 */
public class Interview0102 {
    public boolean CheckPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> cntMap1 = new HashMap<>();
        Map<Character, Integer> cntMap2 = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            cntMap1.merge(s1.charAt(i), 1, Integer::sum);
            cntMap2.merge(s2.charAt(i), 1, Integer::sum);
        }
        if (cntMap1.size() != cntMap2.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> cntMap1Entry : cntMap1.entrySet()) {
            if (!Objects.equals(cntMap2.getOrDefault(cntMap1Entry.getKey(), 0), cntMap1Entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
