package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/15 00:02
 * @description https://leetcode.cn/problems/build-an-array-with-stack-operations/ 1441. 用栈操作构建数组
 */
public class LeetCode1441 {

    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 1;
        for (int num : target) {
            if (index < num) {
                while (index < num) {
                    result.add("Push");
                    result.add("Pop");
                    index++;
                }
            }
            result.add("Push");
            index++;
        }
        return result;
    }
}
