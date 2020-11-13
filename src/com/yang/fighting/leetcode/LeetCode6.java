package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/28 18:46
 * @description https://leetcode-cn.com/problems/zigzag-conversion/
 */

public class LeetCode6 {

    public String convert(String s, int numRows) {
        if (s.length() == 0) {
            return s;
        }
        if (numRows == 1) {
            return s;
        }
        int cubeSize = 2 * numRows - 2;
        int cubeNum = s.length() / cubeSize + 1;
        char[][] tmp = new char[numRows][(numRows - 1) * cubeNum];
        for (int i = 0; i < s.length(); i++) {
            int index = i / (cubeSize);
            int cubeIndex = i % cubeSize;
            System.out.println(i + " " + index + " " + cubeIndex);
            if (cubeIndex < numRows) {
                tmp[cubeIndex][index * (numRows - 1)] = s.charAt(i);
            } else {
                tmp[numRows - 1 - (cubeIndex - (numRows - 1))][(numRows - 1) * index + (cubeIndex - (numRows - 1))] = s.charAt(i);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < (numRows - 1) * cubeNum; j++) {
                if (tmp[i][j] != 0) {
                    stringBuilder.append(tmp[i][j]);
                }
            }
        }
        return stringBuilder.toString();
    }
}
