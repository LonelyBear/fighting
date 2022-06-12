package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/6/12 20:49
 * @description https://leetcode.cn/problems/flip-string-to-monotone-increasing/submissions/ 926. 将字符串翻转到单调递增
 */
public class LeetCode926 {
    /**
     * 遍历分割点找最小点: 左边1数量 + 右边0数量 最小
     * 1的数量通过 前缀和 数组得到
     *
     * @param s
     * @return
     */
    public int minFlipsMonoIncr(String s) {
        char[] array = s.toCharArray();
        int len = s.length();
        int res = len;
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            prefixSum[i] = prefixSum[i - 1] + array[i - 1] - '0';
        }
        for (int i = 1; i <= len; i++) {
            res = Math.min(res, prefixSum[i - 1] + (len - i) - (prefixSum[len] - prefixSum[i]));
        }
        return res;
    }
}
