package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/28 16:41
 * @description https://leetcode-cn.com/problems/palindrome-number/
 */

public class LeetCode9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();
        int ini = x;
        int res = 0;
        while (x != 0) {
            list.add(x % 10);
            x = x / 10;
        }
        for (int i = 0; i < list.size(); i++) {
            res = res * 10 + list.get(i);
        }

        return res == ini;
    }
}
