package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/4 17:23
 * @description https://leetcode-cn.com/problems/russian-doll-envelopes/ 354. 俄罗斯套娃信封问题
 */

public class LeetCode354 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }
        int length = envelopes.length;
        // core: 第一维度按照升序 第二维度按照降序
        // 转化成求最大递增子序列的dp问题
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int res = Integer.compare(o1[0], o2[0]);
                return  res != 0 ? res : Integer.compare(o2[1], o1[1]);
            }
        });
        int[] dp = new int[length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
