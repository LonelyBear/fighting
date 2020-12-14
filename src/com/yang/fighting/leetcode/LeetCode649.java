package com.yang.fighting.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/11 15:48
 * @description https://leetcode-cn.com/problems/dota2-senate/
 */

public class LeetCode649 {
    public String predictPartyVictory(String senate) {
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiantQueue.offer(i);
            } else {
                direQueue.offer(i);
            }
        }
        while (radiantQueue.size() != 0 && direQueue.size() != 0) {
            int radiant = radiantQueue.poll();
            int dire = direQueue.poll();
            if (radiant < dire) {
                radiantQueue.offer(radiant + senate.length());
            } else {
                direQueue.offer(dire + senate.length());
            }
        }
        return !radiantQueue.isEmpty() ? "Radiant" : "Dire";
    }
}
