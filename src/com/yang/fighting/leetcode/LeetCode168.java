package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/29 09:52
 * @description https://leetcode-cn.com/problems/excel-sheet-column-title/ 168. Excel表列名称
 */

public class LeetCode168 {

    private final static int SIZE = 26;

    public String convertToTitle(int columnNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        while (columnNumber > 0) {
            int num = columnNumber % SIZE;
            if (num == 0) {
                stringBuilder.append('Z');
            } else {
                stringBuilder.append((char) ('A' + num - 1));
            }
            columnNumber = (columnNumber - 1) / SIZE;
        }
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
