package com.yang.fighting.leetcode;

import java.util.Arrays;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/11 10:43
 * @description https://leetcode-cn.com/problems/h-index/https://leetcode-cn.com/problems/h-index/ 274. H 指数
 */

public class LeetCode274 {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length - 1;
        int h = 0;
        while (len >= 0 && citations[len] > h) {
            h++;
            len--;
        }
        return h;
    }
}
