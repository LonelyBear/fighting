package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/27 11:27
 * @description https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 */

public class LeetCode4 {
    /**
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int[] tmp = new int[size1 + size2];
        double res = 0d;
        if ((size1 + size2) % 2 == 0) {
            // size1 + size2 为偶数
            int left = (size1 + size2) / 2 - 1;
            int right = left + 1;
            process(nums1, nums2, tmp, right);
            res = ((double) tmp[left] + (double) tmp[right]) / 2;
        } else {
            // size1 + size2 为奇数
            int middle = (size1 + size2) / 2;
            process(nums1, nums2, tmp, middle);
            res = (double) tmp[middle];
        }
        return res;
    }

    /**
     * @param nums1
     * @param nums2
     * @param tmp
     * @param index
     * tips:a++是先赋值再运算，++a是先运算再赋值
     */
    private void process(int[] nums1, int[] nums2, int[] tmp, int index) {
        int cursor1 = 0, cursor2 = 0;
        for (int i = 0; i < nums1.length + nums2.length; i++) {
            if (cursor1 >= nums1.length) {
                tmp[i] = nums2[cursor2++];
            } else if (cursor2 >= nums2.length) {
                tmp[i] = nums1[cursor1++];
            } else if (nums1[cursor1] <= nums2[cursor2]){
                tmp[i] = nums1[cursor1++];
            } else {
                tmp[i] = nums2[cursor2++];
            }
            if (i == index) {
                break;
            }
        }
    }
}

