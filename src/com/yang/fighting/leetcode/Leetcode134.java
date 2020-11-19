package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/18 17:54
 * @description https://leetcode-cn.com/problems/gas-station/
 */

public class Leetcode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int[] difference = new int[gas.length];
        Set<Integer> indexSet = new HashSet<>();
        for (int i = 0; i < gas.length; i++) {
            difference[i] = gas[i] - cost[i];
            if (difference[i] >= 0) {
                indexSet.add(i);
            }
        }
        if (indexSet.size() == 0) {
            return -1;
        }
        int res = -1;
        for (Integer integer : indexSet) {
            int sum = 0;
            for (int i = 0; i < difference.length; i++) {
                sum += integer + i > difference.length - 1
                        ? difference[integer + i - difference.length] : difference[integer + i];
                if (sum < 0) {
                    break;
                }
                if (i == difference.length - 1) {
                    res = integer;
                    return res;
                }
            }
        }
        return res;
    }
}
