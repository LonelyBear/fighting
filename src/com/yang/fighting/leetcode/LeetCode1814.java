package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @date 2023/1/23 19:01
 * @description https://leetcode.cn/problems/count-nice-pairs-in-an-array/ 1814. 统计一个数组中好对子的数目
 */
public class LeetCode1814 {

    private static final int MOD = 1000000007;

    public int countNicePairs(int[] nums) {
        int result = 0;
        // nums[i] - rev(nums[i]) = nums[j] - rev(nums[j])
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int revNum = rev(num);
            result = (result + map.getOrDefault(num - revNum, 0)) % MOD;
            map.merge(num - revNum, 1, Integer::sum);
        }
        return result % MOD;
    }

    private int rev(int num) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean start = false;
        int tmp;
        while (num > 0) {
            tmp = num % 10;
            if (start) {
                stringBuilder.append(tmp);
            } else if (tmp > 0) {
                stringBuilder.append(tmp);
                start = true;
            }
            num /= 10;
        }
        String string = stringBuilder.toString();
        if (string.length() == 0) {
            return 0;
        }
        return Integer.parseInt(string);
    }
}
