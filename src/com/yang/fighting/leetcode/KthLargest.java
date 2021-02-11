package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/11 09:40
 * 703. 数据流中的第 K 大元素
 * @description https://leetcode-cn.com/problems/kth-largest-element-in-a-stream/solution/shu-ju-liu-zhong-de-di-k-da-yuan-su-by-l-woz8/
 */

public class KthLargest {

    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    private final int k;
    private List<Integer> list;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        init(nums);
    }

    public int add(int val) {
        list.add(val);
        list.sort((o1, o2) -> Integer.compare(o2, o1));
        return list.get(k - 1);
    }

    private void init(int[] nums) {
        list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        list.sort((o1, o2) -> Integer.compare(o2, o1));
    }

}
