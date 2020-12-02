package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/2 21:34
 * @description https://leetcode-cn.com/problems/create-maximum-number/
 */
public class LeetCode321 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        if (k == 0 || (nums1.length == 0 && nums2.length == 0)) {
            return new int[0];
        }
        // 遍历两个数组的子序列, 进行数组合并 比较得出最大值
        int size1 = 0;
        int size2 = k;
        if (k > nums2.length) {
            size1 = k - nums2.length;
            size2 = nums2.length;
        }
        int[] maxSubsequence = new int[k];
        while (size1 <= nums1.length && size2 >= 0 && size1 <= k) {
            int[] q1 = getMaxSubsequenceV2(nums1, size1);
            int[] q2 = getMaxSubsequenceV2(nums2, size2);
            int[] merge = merge(q1, q2);
            if (compare(merge, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(merge, 0, maxSubsequence, 0, k);
            }
            size1++;
            size2--;
        }
        return maxSubsequence;
    }

    private int[] getMaxSubsequence(int[] nums, int size) {
        // 单调栈 找到一个单调减的序列 在个数允许的情况下
        int[] stack = new int[size];
        int top = -1;
        int remainSize = nums.length - size;
        for (int num : nums) {
            while (top != -1 && remainSize > 0 && stack[top] < num) {
                top--;
                remainSize--;
            }
            if (top < size - 1) {
                top++;
                stack[top] = num;
            } else {
                remainSize--;
            }
        }
        return stack;
    }

    private int[] getMaxSubsequenceV2(int[] nums, int size) {
        // 单调栈 找到一个单调减的序列 在个数允许的情况下
        Deque<Integer> deque = new LinkedList<>();
        int remainSize = nums.length - size;
        for (int num : nums) {
            while (deque.size() != 0 && deque.peekLast() < num && remainSize > 0) {
                deque.pollLast();
                remainSize--;
            }
            if (deque.size() < size) {
                deque.offerLast(num);
            } else {
                remainSize--;
            }
        }
        int[] stack = new int[size];
        int index = 0;
        while (deque.size() != 0) {
            stack[index++] = deque.pollFirst();
        }
        return stack;
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int x = nums1.length, y = nums2.length;
        if (x == 0) {
            return nums2;
        }
        if (y == 0) {
            return nums1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(nums1, index1, nums2, index2) > 0) {
                merged[i] = nums1[index1];
                index1++;
            } else {
                merged[i] = nums2[index2];
                index2++;
            }
        }
        return merged;
    }

    // 非常巧妙的 compare 一方法两用 真正的大师!!!
    private int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }
}
