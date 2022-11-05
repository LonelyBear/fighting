package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/4 22:26
 * @description https://leetcode.cn/problems/reach-a-number/ 754. 到达终点数字
 */
public class LeetCode754 {
    public int reachNumber(int target) {
        // 这种题思路真的是数学家
        // https://leetcode.cn/problems/reach-a-number/solution/by-ac_oier-o4ze/
        target = Math.abs(target);
        int initial = (int) Math.sqrt(2 * target);
        int dist = initial * (initial + 1) / 2;
        while (dist < target || (dist - target) % 2 == 1) {
            initial++;
            dist = initial * (initial + 1) / 2;
        }
        return initial;
    }
}
