package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/10 10:32
 * @description https://leetcode-cn.com/problems/permutation-in-string/ 567. 字符串的排列
 */

public class LeetCode567 {

    public boolean checkInclusion(String s1, String s2) {
        int expectLen = s1.length();
        int[] countArrayS1 = new int[26];
        int[] countArrayS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            countArrayS1[s1.charAt(i) - 'a']++;
        }
        int left = 0, right = 0;
        while (right < s2.length()) {
            countArrayS2[s2.charAt(right) - 'a']++;
            right++;
            while (compare(countArrayS1, countArrayS2)) {
                countArrayS2[s2.charAt(left) - 'a']--;
                left++;
            }
            if (right - left == expectLen) {
                return true;
            }
        }
        return false;
    }

    private boolean compare(int[] array1, int[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (array1[i] < array2[i]) {
                return true;
            }
        }
        return false;
    }

}
