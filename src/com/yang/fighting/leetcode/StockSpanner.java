package com.yang.fighting.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/21 22:00
 * @description https://leetcode.cn/problems/online-stock-span/ 901. 股票价格跨度
 */
public class StockSpanner {

    private Deque<Integer[]> stack;
    int index;

    public StockSpanner() {
        stack = new ArrayDeque<>();
        stack.addLast(new Integer[]{-1, Integer.MAX_VALUE});
        index = -1;
    }

    public int next(int price) {
        index++;
        while (stack.peekLast()[1] <= price) {
            stack.pollLast();
        }
        int result = index - stack.peekLast()[0];
        stack.addLast(new Integer[]{index, price});
        return result;
    }
}
