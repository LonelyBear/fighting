package com.yang.fighting.leetcode;

import java.util.TreeSet;

/**
 * @author yangtao
 * @date 2023/1/27 11:30
 * @description https://leetcode.cn/problems/exam-room/ 855. 考场就座
 *
 * <p>
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(n);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */

public class ExamRoom {

    private final TreeSet<Integer> seatSet;
    private final int size;

    public ExamRoom(int n) {
        this.seatSet = new TreeSet<>();
        this.size = n;
    }

    public int seat() {
        if (seatSet.isEmpty()) {
            seatSet.add(0);
            return 0;
        }
        int left = seatSet.first(), distance = seatSet.first(), index = 0;
        // 遍历TreeSet
        for (int right : seatSet) {
            if (distance < (right - left) / 2) {
                distance = (right - left) / 2;
                index = (right + left) / 2;
            }
            left = right;
        }
        // 处理最右区间
        int rightDistance = size - 1 - seatSet.last();
        if (distance < rightDistance) {
            distance = rightDistance;
            index = size - 1;
        }
        seatSet.add(index);
        return index;
    }

    public void leave(int p) {
        seatSet.remove(p);
    }

}
