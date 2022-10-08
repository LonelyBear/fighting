package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/8 22:06
 * @description https://leetcode.cn/problems/advantage-shuffle/ 870. 优势洗牌
 */
public class LeetCode870 {
    /**
     * 田忌赛马
     * 用nums1的最小去比nums2的最小
     * 如果比的过则设置为nums2的最小位置
     * 比不过则设置在nums2的最大位置
     *
     * 提前先把nums2的位置数组 从小到大排序好
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Integer[] indexArray = IntStream.range(0, nums1.length).boxed().toArray(Integer[]::new);
        Arrays.sort(nums1);
        Arrays.sort(indexArray, Comparator.comparingInt(o -> nums2[o]));
        int left = 0, right = nums1.length - 1;
        for (int num : nums1) {
            if (num > nums2[indexArray[left]]) {
                ans[indexArray[left]] = num;
                left++;
            } else {
                ans[indexArray[right]] = num;
                right--;
            }
        }
        return ans;
    }
}
