package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/9 10:24
 * @description https://leetcode-cn.com/problems/k-closest-points-to-origin/
 */

public class LeetCode973 {
    public int[][] kClosest(int[][] points, int K) {
//        Arrays.sort(points, Comparator.comparingInt(point -> (point[0] * point[0] + point[1] * point[1])));
//        return Arrays.copyOfRange(points, 0 ,K);

        if (points.length == 0 || points[0].length == 0) {
            return new int[0][0];
        }
        List<Point> closestList = new ArrayList<>();
        int[][] res = new int[K][2];
        for (int i = 0; i < points.length; i++) {
            if (closestList.size() < K
                    || closestList.get(closestList.size() - 1).getDistance() > ((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]))) {
                closestList = addPointToList(closestList, points[i][0], points[i][1], K);
            }
        }
        for (int i = 0; i < closestList.size(); i++) {
            res[i][0] = closestList.get(i).getX();
            res[i][1] = closestList.get(i).getY();
        }
        return res;
    }

    private static class Point {
        private int x;
        private int y;
        private int distance;

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

        public int getDistance() {
            return distance;
        }

        public void setDistance(int distance) {
            this.distance = distance;
        }

        public Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private List<Point> addPointToList(List<Point> list, int x, int y, int K) {
        int distance = x * x + y * y;
        List<Point> newList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).distance < distance) {
                newList.addAll(list.subList(0, i + 1));
                newList.add(new Point(x, y, distance));
                if (i + 1 <= list.size() - 1) {
                    newList.addAll(list.subList(i + 1, list.size()));
                }
                break;
            }
        }
        if (newList.size() == 0) {
            newList.add(new Point(x, y, distance));
            newList.addAll(list);
        }
        if (newList.size() > K) {
            newList.remove(newList.size() - 1);
        }
        return newList;
    }
}
