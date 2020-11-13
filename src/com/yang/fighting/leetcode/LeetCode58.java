package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/10 16:05
 * @description https://leetcode-cn.com/problems/length-of-last-word/
 */

public class LeetCode58 {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if (s.length() == 0) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                list.add(s.charAt(i));
            } else {
                break;
            }
        }
        return list.size();
    }
}
