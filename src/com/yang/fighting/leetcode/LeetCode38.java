package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/6 15:44
 * @description https://leetcode-cn.com/problems/count-and-say/
 */

public class LeetCode38 {

    public String countAndSay(int n) {
        int i = 1;
        String s = "1";
        while (i < n) {
            i++;
            s = process(s);
        }
        return s;
    }

    private String process(String s) {
        List<String> stringList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(index)) {
                stringList.add(s.substring(index, i));
                index = i;
            }
        }
        stringList.add(s.substring(index));
        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : stringList) {
            stringBuilder.append(s1.length());
            stringBuilder.append(s1.charAt(0));
        }
        return stringBuilder.toString();
    }
}
