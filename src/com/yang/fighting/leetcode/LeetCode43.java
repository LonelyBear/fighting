package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/14 16:47
 * @description https://leetcode-cn.com/problems/multiply-strings/ 43. 字符串相乘
 */

public class LeetCode43 {
    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }
        int len1 = num1.length();
        int len2 = num2.length();
        String[] tmp = new String[len2];
        int up = 0;
        for (int i = len2 - 1; i >= 0; i--) {
            StringBuilder builder = new StringBuilder();
            // 先补0
            for (int j = 0; j < len2 - 1 - i; j++) {
                builder.append('0');
            }
            for (int k = len1 - 1; k >= 0; k--) {
                int res = (num1.charAt(k) - '0') * (num2.charAt(i) - '0') + up;
                builder.append(res % 10);
                up = res / 10;
            }
            if (up > 0) {
                builder.append(up);
                up = 0;
            }
            builder.reverse();
            tmp[i] = builder.toString();
        }
        // 转换成大数相加的问题
        return add(tmp);
    }

    private String add(String[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            count[i] = nums[i].length() - 1;
        }
        int up = 0;
        StringBuilder builder = new StringBuilder();
        while (check(count) || up > 0) {
            int res = calcSum(nums, count) + up;
            builder.append(res % 10);
            up = res / 10;
        }
        builder.reverse();
        return builder.toString();
    }

    private boolean check(int[] count) {
        boolean res = false;
        for (int i = 0; i < count.length; i++) {
            if (count[i] >= 0) {
                return true;
            }
        }
        return false;
    }

    private int calcSum(String[] nums, int[] count) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count[i] >= 0) {
                res += nums[i].charAt(count[i]) - '0';
                count[i]--;
            }
        }
        return res;
    }
}
