package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/28 15:10
 * @description https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * 395. 至少有 K 个重复字符的最长子串
 */

public class LeetCode395 {
    public int longestSubstring(String s, int k) {
        // https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters/solution/di-gui-mei-ju-hua-dong-chuang-kou-by-zln-al9a/
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char aChar : s.toCharArray()) {
            map.put(aChar, map.getOrDefault(aChar, 0) + 1);
        }
        for (char aChar : s.toCharArray()) {
            if (map.get(aChar) < k) {
                int ans = 0;
                // 因为该字符不合适,切分为数组, 分治思想
                String[] split = s.split(String.valueOf(aChar));
                for (String subStr : split) {
                    //递归
                    ans = Math.max(ans, longestSubstring(subStr, k));
                }
                return ans;
            }
        }
        //如果每个字符都都满足大于k,会走到此处，当前串满足条件，直接返回字符串长度即可
        return s.length();
    }

}
