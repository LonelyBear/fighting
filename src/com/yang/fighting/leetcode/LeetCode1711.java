package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/7 11:40
 * @description https://leetcode-cn.com/problems/count-good-meals/ 1711. 大餐计数
 */

public class LeetCode1711 {
    public int countPairs(int[] deliciousness) {
        if (deliciousness.length < 2) {
            return 0;
        }
        int mod = 1000000007;
        // 关键的边界条件 2 的 22 次幂
        int max = 1 << 22;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int d : deliciousness) {
            countMap.merge(d, 1, Integer::sum);
        }
        long res = 0;
        for (int x : countMap.keySet()) {
            for (int i = 1; i < max; i = i << 1) {
                int other = i - x;
                if (countMap.containsKey(other)) {
                    if (x == other) {
                        res += (long) (countMap.get(x) - 1) * (long) (countMap.get(x));
                    } else {
                        res += (long) (countMap.get(x)) * (long) (countMap.get(other));
                    }
                }
            }
        }
        res = res >> 1;
        return (int) (res % mod);
    }

}
