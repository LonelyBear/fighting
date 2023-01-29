package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/28 20:21
 * @description https://leetcode.cn/problems/ways-to-make-a-fair-array/ 1664. 生成平衡数组的方案数
 */
public class LeetCode1664 {
    public int waysToMakeFair(int[] nums) {
        int len = nums.length;
        int result = 0,
                totalOddSum = 0, totalEvenSum = 0,
                iterateOddSum = 0, iterateEvenSum = 0,
                exchangeOddSum = 0, exchangeEvenSum = 0;
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                totalEvenSum += nums[i];
            } else {
                totalOddSum += nums[i];
            }
        }
        for (int i = 0; i < len; i++) {
            int currentValue = nums[i];
            // 判断是否为平衡数组
            // 当删除该数后 该索引后面的奇偶数和会交换对调
            // 当删除位次为偶数时:
            //      交换后的偶数和 = 之前迭代过的偶数和 + 总奇数和 - 之前迭代过的奇数和
            //      交换后的奇数和 = 之前迭代过的奇数和 + 总偶数和 - 之前迭代过的偶数和 - 当前值
            // 当删除位次为奇数时:
            //      交换后的偶数和 = 之前迭代过的偶数和 + 总奇数和 - 之前迭代过的奇数和 - 当前值
            //      交换后的奇数和 = 之前迭代过的奇数和 + 总偶数和 - 之前迭代过的偶数和
            if (i % 2 == 0) {
                exchangeEvenSum = iterateEvenSum + totalOddSum - iterateOddSum;
                exchangeOddSum = iterateOddSum + totalEvenSum - iterateEvenSum - currentValue;
                iterateEvenSum += currentValue;
            } else {
                exchangeEvenSum = iterateEvenSum + totalOddSum - iterateOddSum - currentValue;
                exchangeOddSum = iterateOddSum + totalEvenSum - iterateEvenSum;
                iterateOddSum += currentValue;
            }
            if (exchangeEvenSum == exchangeOddSum) {
                result++;
            }
        }
        return result;
    }
}
