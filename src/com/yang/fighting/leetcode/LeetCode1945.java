package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/12/17 22:05
 * @description
 */
public class LeetCode1945 {
    public int getLucky(String s, int k) {
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            builder.append(c - 'a' + 1);
        }
        String num = builder.toString();
        for (int i = 0; i < k; i++) {
            int sum = 0;
            for (int j = 0; j < num.length(); j++) {
                sum += num.charAt(j) - '0';
            }
            num = String.valueOf(sum);
        }
        return Integer.parseInt(num);
    }


}
