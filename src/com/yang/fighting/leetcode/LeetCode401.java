package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/6/21 13:49
 * @description https://leetcode-cn.com/problems/binary-watch/ 401. 二进制手表
 */

public class LeetCode401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + ((m < 10) ? "0" : "") + m);
                }
            }
        }
        return res;
    }
}
