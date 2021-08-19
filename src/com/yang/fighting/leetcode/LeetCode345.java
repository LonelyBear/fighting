package com.yang.fighting.leetcode;

import java.util.Arrays;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/8/19 22:33
 * @description https://leetcode-cn.com/problems/reverse-vowels-of-a-string/ 345. 反转字符串中的元音字母
 */

public class LeetCode345 {

    private static final Set<Character> vowelSet = Set.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');

    public String reverseVowels(String s) {
        if (s.length() == 0) {
            return s;
        }
        int left = 0, right = s.length() - 1;
        char[] array = s.toCharArray();
        while (left <= right) {
            while (left <= right && !vowelSet.contains(array[left])) {
                left++;
            }
            while (left <= right && !vowelSet.contains(array[right])) {
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
            }
            left++;
            right--;
        }
        return String.valueOf(array);
    }

    private void swap(char[] array, int left, int  right) {
        char tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
