package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/12 09:47
 * @description https://leetcode-cn.com/problems/largest-number/ 179. 最大数
 */

public class LeetCode179 {

    public String largestNumber(int[] nums) {
        if (nums.length <= 1) {
            return String.valueOf(nums[0]);
        }
        String[] array = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            array[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(array, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (array[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for (String s : array) {
            sb.append(s);
        }
        return sb.toString();
    }
}
