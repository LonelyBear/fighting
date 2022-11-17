package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/15 22:39
 * @description https://leetcode.cn/problems/maximum-units-on-a-truck/ 1710. 卡车上的最大单元数
 */
public class LeetCode1710 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int ans = 0, remainCnt = truckSize;
        for (int[] boxType : boxTypes) {
            if (remainCnt <= boxType[0]) {
                ans += boxType[1] * remainCnt;
                break;
            }
            remainCnt -= boxType[0];
            ans += boxType[1] * boxType[0];
        }
        return ans;
    }
}
