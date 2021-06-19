package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version  1.0
 * @date 2021/6/19 23:11
 * @description https://leetcode-cn.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/ 1239. 串联字符串的最大长度
 */

public class LeetCode1239 {

    private int res;
    List<Integer> data;

    public int maxLength(List<String> arr) {
        res = 0;
        // 先过滤 arr 中的 重复的项 用二进制数代表某位是否已经包含, 总共最多有26位
        data = new ArrayList<>();
        for (String s : arr) {
            int ele = 0;
            for (int i = 0; i < s.length(); i++) {
                int num = s.charAt(i) - 'a';
                // 如果 检测到这位不为0 则说明这项字符串不能用 直接break
                if (((ele >> num) & 1) != 0) {
                    ele = 0;
                    break;
                }
                ele = ele | 1 << num;
            }
            if (ele > 0) {
                data.add(ele);
            }
        }
        dfs(0, 0);
        return res;
    }

    /**
     * 回溯 dfs
     * @param index
     * @param ele
     */
    private void dfs(int index, int ele) {
        if (index == data.size()) {
            res = Math.max(res, Integer.bitCount(ele));
            return;
        }
        // 和下一个 比较 如果不重合的话 则合并ele
        if ((ele & data.get(index)) == 0) {
            dfs(index + 1, ele | data.get(index));
        }
        dfs(index + 1, ele);
    }
}
