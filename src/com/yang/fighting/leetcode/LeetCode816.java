package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/11/7 18:32
 * @description https://leetcode.cn/problems/ambiguous-coordinates/ 816. 模糊坐标
 */
public class LeetCode816 {
    // 非常简单的枚举分割点 然后在二次枚举分析不可能情况 汇总遍历
    public List<String> ambiguousCoordinates(String _s) {
        String s = _s.substring(1, _s.length() - 1);
        int len  = s.length();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            List<String> a = gen(0, i, s), b = gen(i + 1, len - 1, s);
            for (String a1 : a) {
                for (String b1 : b) {
                    result.add("(" + a1 + ", " + b1 + ")");
                }
            }
        }
        return result;
    }

    private List<String> gen(int start, int end, String s) {
        List<String> result = new ArrayList<>();
        if (start == end || s.charAt(start) != '0') {
            result.add(s.substring(start, end + 1));
        }
        for (int i = start; i < end; i++) {
            String a = s.substring(start, i + 1), b = s.substring(i + 1, end + 1);
            if (a.length() > 1 && a.charAt(0) == '0') {
                continue;
            }
            if (b.charAt(b.length() - 1) == '0') {
                continue;
            }
            result.add(a + "." + b);
        }
        return result;
    }

}
