package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/13 22:08
 * @description https://leetcode.cn/problems/max-chunks-to-make-sorted/ 769. 最多能完成排序的块
 */
public class LeetCode769 {
    public int maxChunksToSorted(int[] arr) {
        // 模拟取数过程
        int n = arr.length;
        int res = 0;
        int left = 0, right = 0;
        int min = n, max = -1;
        for (; right < n; right++) {
            min = Math.min(arr[right], min);
            max = Math.max(arr[right], max);
            if (left == min && right == max) {
                res++;
                left = max + 1;
                max = -1;
                min = n;
            }
        }
        return res;
    }
}
