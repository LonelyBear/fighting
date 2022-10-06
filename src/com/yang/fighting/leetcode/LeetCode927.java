package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/6 19:01
 * @description https://leetcode.cn/problems/three-equal-parts/ 927. 三等分
 */
public class LeetCode927 {
    public int[] threeEqualParts(int[] arr) {
        /*
         * 1. 统计数组中为1的数量
         * 如果1的数量为0 则说明arr都是0, 可以直接返回[0, 2]
         * 如果1的数量不是3的倍数 则说明arr不能被有效分割(分割后的三份肯定是1的数量相同的), 可以直接返回[-1, -1]
         */
        int oneCnt = 0;
        for (int num : arr) {
            oneCnt += num;
        }
        if (oneCnt == 0) {
            return new int[]{0, 2};
        }
        if (oneCnt % 3 != 0) {
            return new int[]{-1, -1};
        }
        /*
         * 遍历一遍arr数组
         * 找到对应的每个分区的首位1坐标
         * 比较三个分段里的相对位置的值是否一致, 不一致则直接返回[-1, -1]
         * 如果遍历结束符合结果, 则返回结果坐标
         */
        int firstOneIndex = findIndex(arr, 1);
        int secondOneIndex = findIndex(arr, oneCnt / 3 + 1);
        int thirdOneIndex = findIndex(arr, 2 * oneCnt / 3 + 1);
        while (thirdOneIndex < arr.length
                && arr[firstOneIndex] == arr[secondOneIndex]
                && arr[secondOneIndex] == arr[thirdOneIndex]) {
            firstOneIndex++;
            secondOneIndex++;
            thirdOneIndex++;
        }
        if (thirdOneIndex == arr.length) {
            return new int[]{firstOneIndex - 1, secondOneIndex};
        }
        return new int[]{-1, -1};
    }

    /**
     * find one index in arr
     *
     * @param arr
     * @param oneCnt
     * @return
     */
    private int findIndex(int[] arr, int oneCnt) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            }
            if (count == oneCnt) {
                return i;
            }
        }
        return 0;
    }
}
