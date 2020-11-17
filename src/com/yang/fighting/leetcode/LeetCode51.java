package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/13 23:38
 * @description https://leetcode-cn.com/problems/n-queens/
 */

public class LeetCode51 {

    public List<List<String>> solveNQueens(int n) {
        if (n == 0) {
            return Collections.emptyList();
        }
        if (n == 1) {
            return Collections.singletonList(Collections.singletonList("Q"));
        }
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Point> tmpList = new ArrayList<>();
            tmpList.add(new Point(0, i));
            process(result, tmpList, 1, n);
        }
        return result;
    }

    private void process(List<List<String>> result, List<Point> tmpList, int x, int n) {
        Set<Integer> set = tmpList.stream().map(Point::getY).collect(Collectors.toSet());
        int i = 0;
        while (i < n) {
            if (set.contains(i)) {
                i++;
                continue;
            }
            boolean check = false;
            for (Point point : tmpList) {
                if (Math.abs(point.x - x) == Math.abs(point.y - i)) {
                    check = true;
                    break;
                }
            }
            if (!check) {
                List<Point> newArray = new ArrayList<>(tmpList);
                newArray.add(new Point(x, i));
                process(result, newArray, x + 1, n);
            }
            i++;
        }
        if (tmpList.size() >= n) {
            result.add(geneString(tmpList));
        }
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

    private List<String> geneString(List<Point> points) {
        System.out.println(Arrays.toString(points.toArray()));
        List<String> stringList = new ArrayList<>(points.size());
        for (Point point : points) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".".repeat(Math.max(0, point.y)));
            stringBuilder.append('Q');
            stringBuilder.append(".".repeat(Math.max(0, points.size() - (point.y + 1))));
            stringList.add(stringBuilder.toString());
        }
        return stringList;
    }
}
