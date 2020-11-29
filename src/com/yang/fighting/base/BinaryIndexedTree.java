package com.yang.fighting.base;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/29 00:23
 * @description 树状数组或二元索引树
 */

public class BinaryIndexedTree {
    /**
     * 树状数组的长度
     */
    private final int size;
    /**
     * 数据存储数组
     */
    private final int[] data;

    public BinaryIndexedTree(int size) {
        this.size = size;
        this.data = new int[size + 1];
    }

    public void update(int index, int d) {
        while (index <= size) {
            data[index] += d;
            index += lowbit(index);
        }
    }

    public int query(int index) {
        int ans = 0;
        while (index != 0) {
            ans += data[index];
            index -= lowbit(index);
        }
        return ans;
    }

    private int lowbit(int index) {
        return index & (-index);
    }
}
