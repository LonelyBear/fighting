package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/12 21:22
 * @description https://leetcode.cn/problems/permutations/?favorite=2cktkvj 46. 全排列
 */
public class LeetCode46 {

    public int balancedString(String s) {
        Map<Character, Integer> cntMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            cntMap.merge(c, 1, Integer::sum);
        }
        int partNum = s.length() / 4;
        if (valid(cntMap, partNum)) {
            return 0;
        }
        int ans = s.length();
        for (int left = 0, right = 0; left < s.length() && right <= s.length(); left++) {
            while (right < s.length() && !valid(cntMap, partNum)) {
                char c = s.charAt(right);
                cntMap.put(c, cntMap.getOrDefault(c, 0) - 1);
                right++;
            }
            // 如果此时不符合就跳出循环 说明 right 到顶了
            if (!valid(cntMap, partNum)) {
                break;
            }
            ans = Math.min(ans, right - left);
            // 移动左位则加一计数
            char c = s.charAt(left);
            cntMap.put(c, cntMap.getOrDefault(c, 0) + 1);
        }
        return ans;
    }

    // 判断字符数是否小于等于 总数的 1/4
    private boolean valid(Map<Character, Integer> cntMap, int partNum) {
        return cntMap.getOrDefault('Q', 0) <= partNum
                && cntMap.getOrDefault('W', 0) <= partNum
                && cntMap.getOrDefault('E', 0) <= partNum
                && cntMap.getOrDefault('R', 0) <= partNum;
    }
}
