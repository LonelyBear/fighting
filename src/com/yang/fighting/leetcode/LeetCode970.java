package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/25 17:00
 * @description https://leetcode-cn.com/problems/powerful-integers/
 */

public class LeetCode970 {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> seen = new HashSet();
        for (int i = 0; i < 20 && Math.pow(x, i) <= bound; ++i)
            for (int j = 0; j < 20 && Math.pow(y, j) <= bound; ++j) {
                int v = (int) Math.pow(x, i) + (int) Math.pow(y, j);
                if (v <= bound)
                    seen.add(v);
            }

        return new ArrayList(seen);
    }
}
