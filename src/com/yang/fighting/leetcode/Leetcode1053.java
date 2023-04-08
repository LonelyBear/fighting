package com.yang.fighting.leetcode;

import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/3 22:00
 * @description https://leetcode.cn/problems/previous-permutation-with-one-swap/ 1053. 交换一次的先前排列
 */
public class Leetcode1053 {
    public int[] prevPermOpt1(int[] arr) {
        int len = arr.length;
        if (len == 1) {
            return arr;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        pq.add(new int[] {len - 1, arr[len - 1]});
        for (int i = len - 2; i >= 0; i--) {
            if (arr[i] <= arr[i + 1]) {
                pq.add(new int[] {i, arr[i]});
            } else {
                while (!pq.isEmpty()) {
                    int[] ele = pq.poll();
                    if (ele[1] < arr[i]) {
                        int tmp = arr[i];
                        arr[i] = arr[ele[0]];
                        arr[ele[0]] = tmp;
                        break;
                    }
                }
                break;
            }
        }
        return arr;
    }
}
