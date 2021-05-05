package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/5 20:40
 * @description https://leetcode-cn.com/problems/delete-and-earn/ 740. 删除并获得点数
 */

public class LeetCode740 {
    public int deleteAndEarn(int[] nums) {
        if (nums.length == 0) return 0;
        // 打家劫舍的进化版本 LeetCode198
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] count = new int[max + 1];
        for (int num : nums) {
            count[num] += num;
        }
        // dp processing
        int first = count[0], second = count[1];
        for (int i = 2; i < count.length; i++) {
            int tmp = second;
            second = Math.max(first + count[i], second);
            first = tmp;
        }
        return second;
    }
}
