package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/17 23:09
 * @description https://leetcode.cn/problems/number-of-matching-subsequences/ 792. 匹配子序列的单词数
 */
public class LeetCode792 {
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0;
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            indexMap.merge(s.charAt(i), newArrayList(i), (old, ele) -> {
                old.addAll(ele);
                return old;
            });
        }
        for (String word : words) {
            if (check(indexMap, word)) {
                result++;
            }
        }
        return result;
    }

    private List<Integer> newArrayList(Integer ele) {
        List<Integer> list = new ArrayList<>();
        list.add(ele);
        return list;
    }

    private boolean check(Map<Character, List<Integer>> indexMap, String word) {
        boolean ok = true;
        int lastIndex = -1;
        for (int i = 0; i < word.length() && ok; i++) {
            List<Integer> indexList = indexMap.getOrDefault(word.charAt(i), Collections.emptyList());
            int left = 0, right = indexList.size() - 1;
            while (left < right) {
                int mid = (left + right) / 2;
                if (indexList.get(mid) > lastIndex) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            if (right < 0 || indexList.get(right) <= lastIndex) {
                ok = false;
                break;
            } else {
                lastIndex = indexList.get(right);
            }
        }
        return ok;
    }
}
