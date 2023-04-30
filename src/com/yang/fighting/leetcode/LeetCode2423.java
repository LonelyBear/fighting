package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/30 09:35
 * @description https://leetcode.cn/problems/remove-letter-to-equalize-frequency/ 2423. 删除字符使频率相同
 */
public class LeetCode2423 {
    public boolean equalFrequency(String word) {
        int[] array = new int[26];
        for (char c : word.toCharArray()) {
            array[c - 'a']++;
        }
        Map<Integer, Integer> cntMap = new HashMap<>();
        for (int num : array) {
            if (num > 0) {
                cntMap.merge(num, 1, Integer::sum);
            }
        }
        for (int ele : array) {
            if (ele == 0) {
                continue;
            }
            cntMap.put(ele, cntMap.get(ele) - 1);
            if (cntMap.get(ele) == 0) {
                cntMap.remove(ele);
            }
            if (ele > 1) {
                cntMap.merge(ele - 1, 1, Integer::sum);
            }
            if (cntMap.size() == 1) {
                return true;
            }
            if (ele > 1) {
                cntMap.put(ele - 1, cntMap.get(ele - 1) - 1);
                if (cntMap.get(ele - 1) == 0) {
                    cntMap.remove(ele - 1);
                }
            }
            cntMap.merge(ele, 1, Integer::sum);
        }
        return false;
    }
}
