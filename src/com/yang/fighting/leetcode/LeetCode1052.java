package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/24 14:56
 * @description https://leetcode-cn.com/problems/grumpy-bookstore-owner/ 1052. 爱生气的书店老板
 */

public class LeetCode1052 {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int len = customers.length;
        int left = 0, right = 0, maxSave = 0, total = 0, save = 0;
        while (right < len) {
            // 增加原本的总值
            if (grumpy[right] != 1) {
                total += customers[right];
            }
            // 增加被拯救的值
            if (grumpy[right] == 1) {
                save += customers[right];
            }
            right++;
            while (right - left > X) {
                // 缩小窗口范围
                if (grumpy[left] == 1) {
                    save -= customers[left];
                }
                left++;
            }
            maxSave = Math.max(maxSave, save);
        }
        return total + maxSave;
    }
}
