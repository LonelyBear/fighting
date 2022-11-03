package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/31 22:31
 * @description https://leetcode.cn/problems/letter-combinations-of-a-phone-number/?favorite=2cktkvj 17. 电话号码的字母组合
 */
public class LeetCode17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('2', Arrays.asList('a', 'b', 'c'));
        map.put('3', Arrays.asList('d', 'e', 'f'));
        map.put('4', Arrays.asList('g', 'h', 'i'));
        map.put('5', Arrays.asList('j', 'k', 'l'));
        map.put('6', Arrays.asList('m', 'n', 'o'));
        map.put('7', Arrays.asList('p', 'q', 'r', 's'));
        map.put('8', Arrays.asList('t', 'u', 'v'));
        map.put('9', Arrays.asList('w', 'x', 'y', 'z'));
        List<String> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        dfs(result, map, digits, list, 0);
        return result;
    }

    private void dfs(List<String> result,
                     Map<Character, List<Character>> map,
                     String digits,
                     List<Character> list,
                     int index) {
        if (index == digits.length()) {
            result.add(toString(list));
            return;
        }
        for (Character c : map.get(digits.charAt(index))) {
            list.add(c);
            dfs(result, map, digits, list, index + 1);
            list.remove(list.size() - 1);
        }
    }

    private String toString(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return builder.toString();
    }
}
