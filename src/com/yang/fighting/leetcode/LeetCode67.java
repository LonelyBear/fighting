package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/13 22:12
 * @description https://leetcode-cn.com/problems/add-binary/
 */

public class LeetCode67 {
    public String addBinary(String a, String b) {
        if ("0".equals(a)) {
            return b;
        }
        if ("0".equals(b)) {
            return a;
        }
        int aSize = a.length();
        int bSize = b.length();
        List<Character> list = new ArrayList<>();
        boolean up = false;
        for (int i = 0; i < Math.max(aSize, bSize); i++) {
            int tmp = 0;
            if (i < aSize) {
                tmp = tmp + a.charAt(aSize - 1 - i) - '0';
            }
            if (i < bSize) {
                tmp = tmp + b.charAt(bSize - 1 - i) - '0';
            }
            if (up) {
                tmp = tmp + 1;
            }
            if (tmp > 1) {
                up = true;
                list.add(tmp == 2 ? '0' : '1');
            } else {
                up = false;
                list.add(tmp == 0 ? '0' : '1');
            }
        }
        if (up) {
            list.add('1');
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.size() - 1; i >= 0; i--) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();
    }
}
