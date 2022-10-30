package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/30 15:59
 * @description https://leetcode.cn/problems/letter-case-permutation/ 784. 字母大小写全排列
 */
public class LeetCode784 {
    public List<String> letterCasePermutation(String s) {
        char[] array = s.toCharArray();
        List<Character> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        dfs(result, array, list, 0);
        return result;
    }

    private void dfs(List<String> result,
                     char[] array,
                     List<Character> list,
                     int index) {
        if (index == array.length) {
            result.add(toString(list));
            return;
        }
        if (array[index] >= '0' && array[index] <= '9') {
            list.add(array[index]);
            dfs(result, array, list, index + 1);
        } else if (array[index] >= 'a' && array[index] <= 'z') {
            list.add(array[index]);
            dfs(result, array, list, index + 1);
            list.remove(list.size() - 1);
            list.add((char) ((int) array[index] - 32));
            dfs(result, array, list, index + 1);
        } else {
            list.add(array[index]);
            dfs(result, array, list, index + 1);
            list.remove(list.size() - 1);
            list.add((char) ((int) array[index] + 32));
            dfs(result, array, list, index + 1);
        }
        list.remove(list.size() - 1);
    }

    private String toString(List<Character> list) {
        StringBuilder builder = new StringBuilder();
        list.forEach(builder::append);
        return builder.toString();
    }
}
