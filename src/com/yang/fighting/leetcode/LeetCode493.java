package com.yang.fighting.leetcode;

import com.yang.fighting.base.BinaryIndexedTree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/28 12:27
 * @description https://leetcode-cn.com/problems/reverse-pairs/
 */

public class LeetCode493 {

    /**
     * 用于存放排序过程中的临时数组
     */
    private int[] tmp;
    /**
     * 结果数量
     */
    private int count;

    public int reversePairs(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        tmp = new int[nums.length];
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        // 归并分治拆分数组
        mergeSort(nums, left, mid);
        mergeSort(nums, mid + 1, right);

        // 遍历数组,找到num[i] > 2 * num[j] 的 i, j 因为左右序列是升序的,
        // 所以 num[i++] > 2 * num[j], 通过索引计算个数
        // 然后增加j 再找到一个符合上诉条件的i值, 节省搜索次数
        int leftIndex = left;
        int rightIndex = mid + 1;
        //System.out.println(left + " # " + right);
        while (leftIndex <= mid && rightIndex <= right) {
            //System.out.println(leftIndex + "  " + rightIndex);
            if (nums[leftIndex] > (long) 2 * nums[rightIndex]) {
                count += mid - leftIndex + 1;
                rightIndex++;
            } else {
                leftIndex++;
            }
        }

        // 遍历搜索后,合并两个序列为升序序列, 再进行上一层的搜索过程
        // 此时用tmp数组进行临时的记录,再进行统一拷贝
        // 重新归化leftIndex 和 rightIndex
        leftIndex = left;
        rightIndex = mid + 1;
        int index = leftIndex;
        while (leftIndex <= mid && rightIndex <= right) {
            if (nums[leftIndex] <= nums[rightIndex]) {
                tmp[index] = nums[leftIndex];
                leftIndex++;
            } else {
                tmp[index] = nums[rightIndex];
                rightIndex++;
            }
            index++;
        }
        while (leftIndex <= mid) {
            tmp[index] = nums[leftIndex];
            index++;
            leftIndex++;
        }
        while (rightIndex <= right) {
            tmp[index] = nums[rightIndex];
            index++;
            rightIndex++;
        }
        System.arraycopy(tmp, left, nums, left, right - left + 1);
    }

    public int reversePairsByBinaryIndexedTree(int[] nums) {
        TreeSet<Long> allNumbers = new TreeSet<Long>();
        for (int x : nums) {
            allNumbers.add((long) x);
            allNumbers.add((long) x * 2);
        }
        // 利用哈希表进行离散化
        Map<Long, Integer> values = new HashMap<Long, Integer>();
        int idx = 0;
        for (long x : allNumbers) {
            values.put(x, idx);
            idx++;
        }

        int ret = 0;
        BinaryIndexedTree bit = new BinaryIndexedTree(values.size());
        for (int num : nums) {
            int left = values.get((long) num * 2), right = values.size() - 1;
            ret += bit.query(right + 1) - bit.query(left + 1);
            bit.update(values.get((long) num) + 1, 1);
        }
        return ret;
    }
}
