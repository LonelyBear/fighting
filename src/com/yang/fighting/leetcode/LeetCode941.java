package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/3 11:03
 * @description https://leetcode-cn.com/problems/valid-mountain-array/
 */

public class LeetCode941 {
    public boolean validMountainArray(int[] A) {
        if (A.length < 3) {
            return false;
        }
        int left = 0;
        int right = A.length - 1;
        boolean leftHigh = false;
        boolean rightHigh = false;
        while (left <= right) {
            if (left == right) {
                break;
            }
            if (left + 1 > A.length - 1) {
                break;
            }
            if (A[left] == A[left + 1]) {
                return false;
            }
            if (A[right] == A[right - 1]) {
                return false;
            }
            if (A[left] >= A[left + 1]) {
                leftHigh = true;
            }
            if (A[right] > A[right - 1]) {
                rightHigh = true;
            }
            if (leftHigh && rightHigh) {
                break;
            }
            if (A[left] < A[left + 1]) {
                left++;
            }
            if (A[right] < A[right - 1]) {
                right--;
            }
        }
        return (left >= right && left > 0 && right < A.length - 1);
    }
}
