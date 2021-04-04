package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/4/4 14:50
 * @description https://leetcode-cn.com/problems/rabbits-in-forest/ 781. 森林中的兔子
 */

public class LeetCode781 {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int ans : answers) {
            countMap.merge(ans + 1, 1, Integer::sum);
        }
        // System.out.println(countMap);
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            int tmp = 0;
            if (key == 1) {
                tmp = value;
            } else {
                int slice = 0;
                slice = value / key;
                slice = value % key == 0 ? slice : slice + 1;
                tmp = key * slice;
            }
            result += tmp;
        }
        return result;
    }
}
