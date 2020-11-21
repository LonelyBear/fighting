package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/22 00:09
 * @description https://leetcode-cn.com/problems/valid-anagram/
 */

public class LeetCode242 {
    // 可以不用list 直接用array的api比较
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int len = s.length();
        List<Character> sList = new ArrayList<>(len);
        List<Character> tList = new ArrayList<>(len);
        for (int i = 0; i < len; i++) {
            sList.add(s.charAt(i));
            tList.add(t.charAt(i));
        }
        Collections.sort(sList);
        Collections.sort(tList);
        for (int i = 0; i < len; i++) {
            if (!sList.get(i).equals(tList.get(i))) {
                return false;
            }
        }
        return true;
    }
}
