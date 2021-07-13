package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/12 10:35
 * @description https://leetcode-cn.com/problems/h-index-ii/ 275. H 指数 II
 */

public class LeetCode275 {
    public int hIndex(int[] citations) {
        int len = citations.length;
        // 二分查找
        // 找到对应的条件 citations[i] >= len - i 的最大i值
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] >= len - mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return len - left;
    }
}
