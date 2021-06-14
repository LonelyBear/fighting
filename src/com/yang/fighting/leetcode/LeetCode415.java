package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/12 09:52
 * @description https://leetcode-cn.com/problems/add-strings/ 415. 字符串相加
 */

public class LeetCode415 {
    public String addStrings(String num1, String num2) {
        char[] arr1 = num1.toCharArray();
        char[] arr2 = num2.toCharArray();
        int len1 = arr1.length - 1;
        int len2 = arr2.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        int up = 0;
        while (len1 >= 0 || len2 >= 0 || up != 0) {
            int x = (len1 >= 0) ? arr1[len1] - '0' : 0;
            int y = (len2 >= 0) ? arr2[len2] - '0' : 0;
            int res = x + y + up;
            stringBuilder.append(res % 10);
            up = res / 10;
            len1--;
            len2--;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
