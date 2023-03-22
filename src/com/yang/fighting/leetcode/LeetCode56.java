package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/20 22:08
 * @description https://leetcode.cn/problems/merge-intervals/?favorite=2cktkvj 56. 合并区间
 */
public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        List<int[]> originList = new ArrayList<>(Arrays.asList(intervals)).stream()
                .sorted(Comparator.comparingInt(o -> o[0]))
                .collect(Collectors.toList());
        int[] tmp = new int[] {-1, -1};
        for (int[] ele : originList) {
            if (tmp[0] == -1) {
                tmp[0] = ele[0];
                tmp[1] = ele[1];
                continue;
            }
            if (ele[0] > tmp[1]) {
                result.add(new int[] {tmp[0], tmp[1]});
                tmp[0] = ele[0];
                tmp[1] = ele[1];
            } else if (ele[1] <= tmp[1]) {
            } else {
                tmp[1] = ele[1];
            }
        }
        result.add(new int[] {tmp[0], tmp[1]});
        int[][] ans = new int[result.size()][2];
        for (int i = 0; i < result.size(); i++) {
            ans[i][0] = result.get(i)[0];
            ans[i][1] = result.get(i)[1];
        }
        return ans;
    }
}
