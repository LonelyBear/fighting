package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/12 09:58
 * @description https://leetcode-cn.com/problems/pascals-triangle-ii/ 119. 杨辉三角 II
 */

public class LeetCode119 {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> current = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    current.add(1);
                    continue;
                }
                current.add(list.get(j - 1) + list.get(j));
            }
            list = current;
        }
        return list;
    }
}
