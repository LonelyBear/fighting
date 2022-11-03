package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/2 22:06
 * @description https://leetcode.cn/problems/coordinate-with-maximum-network-quality/ 1620. 网络信号最好的坐标
 */
public class LeetCode1620 {
    public int[] bestCoordinate(int[][] towers, int radius) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            for (int j = 0; j <= 50; j++) {
                int ans = 0;
                for (int[] tower : towers) {
                    int d2 = (i - tower[0]) * (i - tower[0]) + (j - tower[1]) * (j - tower[1]);
                    if (d2 > radius * radius) {
                        continue;
                    }
                    ans += Math.floor((double) tower[2] / (Math.sqrt(d2) + 1));
                }
                result.add(new int[]{i, j, ans});
            }
        }
        result.sort((Comparator<int[]>) (o1, o2) -> {
            if (o1[2] != o2[2]) {
                return Integer.compare(o2[2], o1[2]);
            }
            if (o1[0] != o2[0]) {
                return Integer.compare(o1[0], o2[0]);
            }
            return Integer.compare(o1[2], o2[2]);
        });
        int[] r = result.get(0);
        return new int[]{r[0], r[1]};
    }
}
