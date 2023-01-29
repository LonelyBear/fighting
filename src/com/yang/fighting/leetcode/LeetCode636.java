package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author yangtao
 * @date 2022/8/7 23:25
 * @description https://leetcode.cn/problems/exclusive-time-of-functions/ 636. 函数的独占时间
 */
public class LeetCode636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        String START_TAG = "start";
        String END_TAG = "end";
        int[] res = new int[n];
        int cur = -1;
        Deque<Integer> stack = new LinkedList<>();
        for (String log : logs) {
            String[] arrays = log.split(":");
            if (START_TAG.equals(arrays[1])) {
                if (!stack.isEmpty()) {
                    res[stack.peek()] += Integer.parseInt(arrays[2]) - cur;
                }
                stack.push(Integer.parseInt(arrays[0]));
                cur = Integer.parseInt(arrays[2]);
                continue;
            }
            if (END_TAG.equals(arrays[1])) {
                res[stack.pop()] += Integer.parseInt(arrays[2]) - cur + 1;
                cur = Integer.parseInt(arrays[2]) + 1;
            }
        }
        return res;
    }

}
