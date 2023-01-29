package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @date 2023/1/23 15:06
 * @description https://leetcode.cn/problems/rearrange-characters-to-make-target-string/ 2287. 重排字符形成目标字符串
 */
public class LeetCode2287 {
    public int rearrangeCharacters(String s, String target) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for (char c : s.toCharArray()) {
            map1.merge(c, 1, Integer::sum);
        }
        for (char c : target.toCharArray()) {
            map2.merge(c, 1, Integer::sum);
        }
        int ans = Integer.MAX_VALUE, tmp;
        for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
            tmp = map1.getOrDefault(entry.getKey(), 0) / entry.getValue();
            if (tmp == 0) {
                return 0;
            }
            ans = Math.min(tmp, ans);
        }
        return ans;
    }
}
