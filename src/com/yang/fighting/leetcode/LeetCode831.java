package com.yang.fighting.leetcode;

import javax.xml.stream.events.Characters;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/1 21:20
 * @description https://leetcode.cn/problems/masking-personal-information/ 831. 隐藏个人信息
 */
public class LeetCode831 {

    private static final String MAIL_REPLACE_STR = "*****";

    private static final String PHONE_REPLACE_STR = "***-***-";

    public String maskPII(String s) {
        String ans = null;
        if (s.contains("@")) {
            String[] array = s.split("@");
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(to(array[0].charAt(0)));
            stringBuilder.append(MAIL_REPLACE_STR);
            stringBuilder.append(to(array[0].charAt(array[0].length() - 1)));
            stringBuilder.append("@");
            for (int i = 0; i < array[1].length(); i++) {
                stringBuilder.append(to(array[1].charAt(i)));
            }
            ans = stringBuilder.toString();
        } else {
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    list.add(s.charAt(i));
                }
            }
            int size = list.size();
            int preSize = size - 10;
            StringBuilder stringBuilder = new StringBuilder();
            if (preSize > 0) {
                stringBuilder.append("+");
                for (int i = 0; i < preSize; i++) {
                    stringBuilder.append("*");
                }
                stringBuilder.append("-");
            }
            stringBuilder.append(PHONE_REPLACE_STR);
            for (int i = 4; i > 0; i--) {
                stringBuilder.append(list.get(size - i));
            }
            ans = stringBuilder.toString();
        }
        return ans;
    }


    private char to(char a) {
        if (a >= 'A' && a <= 'Z') {
            return (char) (a + 'a' - 'A');
        }
        return a;
    }
}
