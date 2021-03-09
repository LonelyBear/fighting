package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/8 10:36
 * @description https://leetcode-cn.com/problems/next-greater-element-i/ 496. 下一个更大元素 I
 */

public class LeetCode496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> deque = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        for (int i = 0; i < nums2.length; i++) {
            while (!deque.isEmpty() && nums2[deque.peek()] < nums2[i]) {
                map.put(nums2[deque.pop()], nums2[i]);
            }
            deque.push(i);
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}
