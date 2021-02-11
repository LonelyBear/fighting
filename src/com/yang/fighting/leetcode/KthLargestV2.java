package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/11 10:07
 * 703. 数据流中的第 K 大元素
 * @description https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/solution/shu-ju-liu-zhong-de-di-k-da-yuan-su-by-l-woz8/
 */

public class KthLargestV2 {

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    private final int k;
    private PriorityQueue<Integer> priorityQueue;

    public KthLargestV2(int k, int[] nums) {
        this.k = k;
        init(nums);
    }

    public int add(int val) {
        priorityQueue.offer(val);
        // 如果大于K,则移除元素
        while (priorityQueue.size() > k) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    private void init(int[] nums) {
        priorityQueue = new PriorityQueue<>();
        // 把数字放入优先队列里, 从小到大排序
        for (int num : nums) {
            priorityQueue.add(num);
        }
    }
}
