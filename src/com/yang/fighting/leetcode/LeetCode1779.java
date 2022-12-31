package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/12/1 10:25
 * @description https://leetcode.cn/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/ 1779. 找到最近的有相同 X 或 Y 坐标的点
 */
public class LeetCode1779 {
    public int nearestValidPoint(int x, int y, int[][] points) {
        int[] result = new int[]{-1, Integer.MAX_VALUE};
        for (int i = 0; i < points.length; i++) {
            int[] point = points[i];
            if (point[0] != x && point[1] != y) {
                continue;
            }
            int distance = (point[0] - x) * (point[0] - x) + (point[1] - y) * (point[1] - y);
            if (distance == 0) {
                return i;
            }
            if (distance < result[1]) {
                result[0] = i;
                result[1] = distance;
            }
        }
        return result[0];
    }
}
