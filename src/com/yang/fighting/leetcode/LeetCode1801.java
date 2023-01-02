package com.yang.fighting.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/1/2 16:54
 * @description https://leetcode.cn/problems/number-of-orders-in-the-backlog/ 1801. 积压订单中的订单总数
 */
public class LeetCode1801 {

    private PriorityQueue<int[]> buyPq;
    private PriorityQueue<int[]> sellPq;
    private static final long MOD = (long) 1e9 + 7;

    public int getNumberOfBacklogOrders(int[][] orders) {
        buyPq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[0], o1[0]));
        sellPq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] order : orders) {
            int orderNum = order[1];
            if (order[2] == 0) {
                while (!sellPq.isEmpty() && orderNum > 0) {
                    int[] sellOrder = sellPq.peek();
                    if (sellOrder[0] > order[0]) {
                        break;
                    } else {
                        if (sellOrder[1] > orderNum) {
                            sellOrder[1] -= orderNum;
                            orderNum = 0;
                            break;
                        } else {
                            orderNum -= sellOrder[1];
                            sellPq.poll();
                        }
                    }
                }
                if (orderNum != 0) {
                    buyPq.add(new int[]{order[0], orderNum});
                }
            } else {
                while (!buyPq.isEmpty() && orderNum > 0) {
                    int[] buyOrder = buyPq.peek();
                    if (buyOrder[0] < order[0]) {
                        break;
                    } else {
                        if (buyOrder[1] > orderNum) {
                            buyOrder[1] -= orderNum;
                            orderNum = 0;
                            break;
                        } else {
                            orderNum -= buyOrder[1];
                            buyPq.poll();
                        }
                    }
                }
                if (orderNum != 0) {
                    sellPq.add(new int[]{order[0], orderNum});
                }
            }
        }
        return calcRemainOrderSize();
    }

    private int calcRemainOrderSize() {
        long result = 0L;

        result += calcPqOrderSize(buyPq);
        result += calcPqOrderSize(sellPq);
        return (int) (result % MOD);
    }

    private long calcPqOrderSize(PriorityQueue<int[]> pq) {
        if (pq.isEmpty()) {
            return 0;
        }
        long result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll()[1] % MOD;
        }
        return result;
    }
}