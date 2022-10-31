package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/31 21:23
 * @description https://leetcode.cn/problems/magical-string/ 481. 神奇字符串
 */
public class LeetCode481 {
    public int magicalString(int n) {
        if (n == 1) return 1;
        int[] nums = new int[101000];
        nums[1] = 1;
        nums[2] = 2;
        int slow = 2, fast = 1, last = 1, result = 1;
        while (fast < n) {
            int next = getNext(nums[last]);
            for (int i = 1; i <= nums[slow]; i++) {
                nums[fast + i] = next;
                if (next == 1 && fast + i <= n) {
                    result++;
                }
            }
            last = next;
            fast += nums[slow];
            slow++;
        }
        return result;
    }

    private int getNext(int last) {
        if (last == 1) return 2;
        return 1;
    }
}
