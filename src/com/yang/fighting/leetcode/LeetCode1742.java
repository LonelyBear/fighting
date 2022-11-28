package com.yang.fighting.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/23 23:29
 * @description https://leetcode.cn/problems/maximum-number-of-balls-in-a-box/ 1742. 盒子中小球的最大数量
 */
public class LeetCode1742 {
    public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = lowLimit; i <= highLimit; i++) {
            int sum = 0;
            int tmp = i;
            while (tmp != 0) {
                sum += tmp % 10;
                tmp /= 10;
            }
            map.merge(sum, 1, Integer::sum);
        }
        return map.entrySet().stream()
                .sorted((o1, o2) -> Integer.compare(o2.getValue(), o1.getValue()))
                .collect(Collectors.toList())
                .get(0)
                .getValue();
    }
}
