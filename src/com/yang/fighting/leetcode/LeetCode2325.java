package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/1 20:58
 * @description https://leetcode.cn/problems/decode-the-message/ 2325. 解密消息
 */
public class LeetCode2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char init = 'a';
        for (char c : key.toCharArray()) {
            if (map.containsKey(c)) {
                continue;
            }
            if (c == ' ') {
                map.put(c, ' ');
                continue;
            }
            map.put(c, init);
            init++;
        }
        StringBuilder builder = new StringBuilder();
        for (char c : message.toCharArray()) {
            builder.append(map.getOrDefault(c, ' '));
        }
        return builder.toString();
    }
}
