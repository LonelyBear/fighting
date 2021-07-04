package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/3 21:21
 * @description https://leetcode-cn.com/problems/chuan-di-xin-xi/ LCP 07. 传递信息
 */

public class LCP07 {
    public int numWays(int n, int[][] relation, int k) {
        Map<Integer, Set<Integer>> indexMap = new HashMap<>();
        for (int[] r : relation) {
            Set<Integer> set;
            if (indexMap.containsKey(r[0])) {
                set = indexMap.get(r[0]);
            } else {
                set = new HashSet<>();
            }
            set.add(r[1]);
            indexMap.put(r[0], set);
        }
        Queue<int[]> queue = new LinkedList<>();
        Set<Integer> intSet = indexMap.get(0);
        for (Integer num : intSet) {
            queue.offer(new int[]{num, 1});
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int[] val = queue.poll();
            if (val[1] > k) {
                continue;
            }
            if (val[0] == n - 1 && val[1] == k) {
                count++;
            } else {
                Set<Integer> set = indexMap.get(val[0]);
                if (set != null) {
                    for (int num : set) {
                        queue.offer(new int[]{num, val[1] + 1});
                    }
                }
            }
        }
        return count;
    }
}
