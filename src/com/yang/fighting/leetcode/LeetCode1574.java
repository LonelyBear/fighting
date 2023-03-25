package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/25 15:21
 * @description https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/ 1574. 删除最短的子数组使剩余数组有序
 */
public class LeetCode1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        int len = arr.length, j = len - 1;
        while (j > 0 && arr[j - 1] <= arr[j]) {
            j--;
        }
        if (j == 0) {
            return 0;
        }
        int ans = j;
        for (int i = 0; i < len; i++) {
            while (j < len && arr[j] < arr[i]) {
                j++;
            }
            ans = Math.min(ans, j - i - 1);
            if (i + 1 < len && arr[i] > arr[i + 1]) {
                break;
            }
        }

        return ans;
    }
}
