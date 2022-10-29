package com.yang.fighting.leetcode;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/29 17:49
 * @description https://leetcode.cn/problems/count-items-matching-a-rule/ 1773. 统计匹配检索规则的物品数量
 */
public class LeetCode1773 {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        AtomicInteger result = new AtomicInteger(0);
        int index = 0;
        switch (ruleKey) {
            case "type":
                index = 0;
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;
        }
        int finalIndex = index;
        items.parallelStream().forEach(list -> {
            if (ruleValue.equals(list.get(finalIndex))) {
                result.addAndGet(1);
            }
        });
        return result.get();
    }
}
