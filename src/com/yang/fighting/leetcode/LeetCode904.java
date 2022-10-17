package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/17 21:41
 * @description https://leetcode.cn/problems/fruit-into-baskets/ 904. 水果成篮
 */
public class LeetCode904 {
    public int totalFruit(int[] fruits) {
        // 滑动窗口 双指针题
        int len = fruits.length;
        int ans = 0;
        int left = 0, right = 0;
        int[] cntArray = new int[len];
        int levelTmp = 0;
        while (right < len) {
            cntArray[fruits[right]]++;
            if (cntArray[fruits[right]] == 1) {
                levelTmp++;
            }
            while (levelTmp > 2) {
                cntArray[fruits[left]]--;
                if (cntArray[fruits[left]] == 0) {
                    levelTmp--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }
        return ans;
    }
}
