package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/24 09:28
 * @description https://leetcode.cn/problems/queries-on-number-of-points-inside-a-circle/ 1828. 统计一个圆中点的数目
 */
public class LeetCode1828 {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] result = new int[queries.length];
        int cnt;
        for (int i = 0; i < queries.length; i++) {
            cnt = 0;
            int[] query = queries[i];
            for (int[] point : points) {
                if (calcDistance(point, query) <= query[2] * query[2]) {
                    cnt++;
                }
            }
            result[i] = cnt;
        }
        return result;
    }

    private int calcDistance(int[] point, int[] query) {
        return (point[0] - query[0]) * (point[0] - query[0]) + (point[1] - query[1]) * (point[1] - query[1]);
    }
}
