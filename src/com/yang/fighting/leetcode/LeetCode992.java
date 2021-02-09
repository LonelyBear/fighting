package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/9 10:24
 * @description https://leetcode-cn.com/problems/subarrays-with-k-different-integers/ 992. K 个不同整数的子数组
 */

public class LeetCode992 {

    public int subarraysWithKDistinct(int[] A, int K) {
        /*
         * 分解问题为
         * 存在 K 个不同整数的子区间的个数 = 最多存在 K 个不同整数的子区间的个数 - 最多存在 K - 1 个不同整数的子区间的个数
         * 最多存在 K 个不同整数的子区间的个数 通过双指针方式来解决
         */
        return process(A, K) - process(A, K - 1);
    }

    /**
     * 双指针 - 计算最多存在 K 个不同整数的子区间的个数
     *
     * @param array
     * @param K
     * @return
     */
    private int process(int[] array, int K) {
        int len = array.length;
        // 记录出现过的数字次数
        int[] countArray = new int[len + 1];
        // left - 左指针
        // right - 右指针
        // res - 计算结果
        // count - 当前子数组中的不同数的个数
        int left = 0, right = 0, res = 0, count = 0;
        while (right < len) {
            if (countArray[array[right]] == 0) {
                count++;
            }
            countArray[array[right]]++;
            // 移动右指针
            right++;
            // 如果 count > K 则进行移动左指针找到符合的值
            while (count > K) {
                countArray[array[left]]--;
                if (countArray[array[left]] == 0) {
                    count--;
                }
                left++;
            }
            // 这个时候 [left, right]区间属于临界区, 依当前右边界的包含的子区间个数为 right - left
            res += right - left;
        }
        return res;
    }
}
