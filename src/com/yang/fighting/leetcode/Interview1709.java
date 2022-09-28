package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/9/28 22:36
 * @description https://leetcode.cn/problems/get-kth-magic-number-lcci/ 面试题 17.09. 第 k 个数
 */
public class Interview1709 {
    public int getKthMagicNumber(int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long index = 1, res = 0;
        pq.add(1L);
        Set<Long> set = new HashSet<>();
        while (index <= k) {
            res = pq.poll();
            index++;
            if (!set.contains(3 * res)) {
                pq.add(3 * res);
                set.add(3 * res);
            }
            if (!set.contains(5 * res)) {
                pq.add(5 * res);
                set.add(5 * res);
            }
            if (!set.contains(7 * res)) {
                pq.add(7 * res);
                set.add(7 * res);
            }
        }
        return (int) res;
    }
}
