package com.yang.fighting.leetcode;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @date 2023/1/21 09:51
 * @description https://leetcode.cn/problems/evaluate-the-bracket-pairs-of-a-string/ 1807. 替换字符串中的括号内容
 */
public class LeetCode1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> knowledgeMap = knowledge.stream()
                .collect(Collectors.toMap(list -> list.get(0), list -> list.get(1), (e1, e2) -> e1));
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(') {
                stringBuilder.append(s.charAt(i));
            } else {
                Pair pair = process(s, i, knowledgeMap);
                i += pair.offset;
                stringBuilder.append(pair.value);
            }
        }
        return stringBuilder.toString();
    }

    private static class Pair {
        public Integer offset;
        public String value;

        public Pair(Integer offset, String value) {
            this.offset = offset;
            this.value = value;
        }
    }

    private Pair process(String s,
                         int index,
                         Map<String, String> knowledgeMap) {
        int i = index + 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ')') {
            stringBuilder.append(s.charAt(i));
            i++;
        }
        return new Pair(i - index, knowledgeMap.getOrDefault(stringBuilder.toString(), "?"));
    }
}
