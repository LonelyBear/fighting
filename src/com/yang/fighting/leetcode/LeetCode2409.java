package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/17 21:16
 * @description https://leetcode.cn/problems/count-days-spent-together/ 2409. 统计共同度过的日子数
 */
public class LeetCode2409 {

    private static final Map<Integer, Integer> monthDayMap = new HashMap<>();
    static {
        monthDayMap.put(1, 31);
        monthDayMap.put(2, 28);
        monthDayMap.put(3, 31);
        monthDayMap.put(4, 30);
        monthDayMap.put(5, 31);
        monthDayMap.put(6, 30);
        monthDayMap.put(7, 31);
        monthDayMap.put(8, 31);
        monthDayMap.put(9, 30);
        monthDayMap.put(10, 31);
        monthDayMap.put(11, 30);
        monthDayMap.put(12, 31);
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] arriveAliceDate = transToDate(arriveAlice);
        int[] leaveAliceDate = transToDate(leaveAlice);
        int[] arriveBobDate = transToDate(arriveBob);
        int[] leaveBobDate = transToDate(leaveBob);
        if (compare(arriveAliceDate, leaveBobDate) > 0 || compare(leaveAliceDate, arriveBobDate) < 0) {
            return 0;
        }
        int[] start = null;
        int[] end = null;
        if (compare(arriveAliceDate, arriveBobDate) <= 0) {
            start = arriveBobDate;
        } else {
            start = arriveAliceDate;
        }

        if (compare(leaveAliceDate, leaveBobDate) <= 0) {
            end = leaveAliceDate;
        } else {
            end = leaveBobDate;
        }

        return calcCommonDays(start, end);
    }


    private int[] transToDate(String str) {
        char[] array = str.toCharArray();
        int[] result = new int[2];
        result[0] = Integer.parseInt(String.valueOf(new char[]{array[0], array[1]}));
        result[1] = Integer.parseInt(String.valueOf(new char[]{array[3], array[4]}));
        return result;
    }

    private int compare(int[] date1, int[] date2) {
        if (date1[0] < date2[0]) {
            return -1;
        }
        if (date1[0] > date2[0]) {
            return 1;
        }
        return Integer.compare(date1[1], date2[1]);
    }

    private int calcCommonDays(int[] date1, int[] date2) {
        if (compare(date1, date2) > 0) {
            return calcCommonDays(date2, date1);
        }
        if (date1[0] == date2[0]) {
            return Math.abs(date1[1] - date2[1]) + 1;
        }
        int days = 0;
        days += (monthDayMap.get(date1[0]) - date1[1] + 1);
        for (int i = date1[0] + 1; i < date2[0]; i++) {
            days += monthDayMap.get(i);
        }
        days += date2[1];
        return days;
    }
}
