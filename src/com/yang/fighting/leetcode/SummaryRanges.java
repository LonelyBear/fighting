package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/19 15:46
 * @description https://leetcode-cn.com/problems/data-stream-as-disjoint-intervals/
 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */

public class SummaryRanges {

    TreeSet<Integer> numSet;
    int[][] intervals;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        numSet = new TreeSet<>();
    }

    public void addNum(int val) {
        if (numSet.contains(val)) {
            return;
        }
        numSet.add(val);
        updateIntervalsArray();
    }

    public int[][] getIntervals() {
        return intervals;
    }

    private void updateIntervalsArray() {
        List<Point> points = new ArrayList<>();
        int left = 0;
        boolean leftFlag = false;
        int tmp = 0;
        for (Integer num : numSet) {
            if (!leftFlag) {
                left = num;
                leftFlag = true;
                tmp = num;
            } else {
                if (num - tmp != 1) {
                    points.add(new Point(left, tmp));
                    left = num;
                    tmp = num;
                } else {
                    tmp = num;
                }
            }
        }
        points.add(new Point(left, tmp));
        int[][] newArray = new int[points.size()][2];
        for (int i = 0; i < points.size(); i++) {
            newArray[i][0] = points.get(i).x;
            newArray[i][1] = points.get(i).y;
        }
        intervals = newArray;
    }

    private static class Point {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }


}
