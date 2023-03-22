package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/11 13:40
 * @description https://leetcode.cn/problems/find-longest-subarray-lcci/ 面试题 17.05.  字母与数字
 */
public class Interview1705 {
    public String[] findLongestSubarray(String[] array) {
        // 前缀和
        Map<Integer, Integer> indexMap = new HashMap<>();
        indexMap.put(0, -1);
        int sum = 0, maxLen = 0, startIndex = -1;
        for (int i = 0; i < array.length; i++) {
            if (Character.isLetter(array[i].charAt(0))) {
                sum++;
            } else {
                sum--;
            }
            if (indexMap.containsKey(sum)) {
                int val = indexMap.get(sum);
                if (i - val > maxLen) {
                    maxLen = i - val;
                    startIndex = val + 1;
                }
            } else {
                indexMap.put(sum, i);
            }
        }
        if (maxLen == 0) {
            return new String[0];
        }
        String[] ans = new String[maxLen];
        System.arraycopy(array, startIndex, ans, 0, maxLen);
        return ans;
    }
}
