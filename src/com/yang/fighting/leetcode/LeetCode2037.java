package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/12/31 15:26
 * @description https://leetcode.cn/problems/minimum-number-of-moves-to-seat-everyone/ 2037. 使每位学生都有座位的最少移动次数
 */
public class LeetCode2037 {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int result = 0;
        for (int i = 0; i < seats.length; i++) {
            result += Math.abs(seats[i] - students[i]);
        }
        return result;
    }
}
