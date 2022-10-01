package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/1 18:04
 * @description https://leetcode.cn/problems/reformat-phone-number/ 1694. 重新格式化电话号码
 */
public class LeetCode1694 {
    public String reformatNumber(String number) {
        List<String> nums = new ArrayList<>();
        for (char s : number.toCharArray()) {
            if (s == ' ' || s == '-') {
                continue;
            }
            nums.add(String.valueOf(s));
        }
        int ccc = nums.size() % 3;
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int i = 0;
        if (ccc == 0) {
            while (i < nums.size()) {
                list.add(nums.get(i) + nums.get(i + 1) + nums.get(i + 2));
                i = i + 3;
            }
        } else if (ccc == 1) {
            while (i < nums.size() - 4) {
                list.add(nums.get(i) + nums.get(i + 1) + nums.get(i + 2));
                i = i + 3;
            }
            list.add(nums.get(i) + nums.get(i + 1));
            list.add(nums.get(i + 2) + nums.get(i + 3));
        } else {
            while (i < nums.size() - 2) {
                list.add(nums.get(i) + nums.get(i + 1) + nums.get(i + 2));
                i = i + 3;
            }
            list.add(nums.get(i) + nums.get(i + 1));
        }
        list.forEach(e -> {
            sb.append(e).append("-");
        });
        String tmp = sb.toString();
        return tmp.substring(0, tmp.length() - 1);
    }
}
