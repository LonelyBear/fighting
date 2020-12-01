package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/30 10:30
 * @description https://leetcode-cn.com/problems/reorganize-string/
 */

public class LeetCode767 {
    public String reorganizeString(String S) {
        int len = S.length();
        int[] countArray = new int[26];
        int thre = (len + 1) >> 1;
        int maxNum = 0;
        int maxCharIndex = 0;
        for (int i = 0; i < len; i++) {
            countArray[S.charAt(i) - 'a']++;
            if (countArray[S.charAt(i) - 'a'] > maxNum) {
                maxNum = countArray[S.charAt(i) - 'a'];
                maxCharIndex = S.charAt(i) - 'a';
                if (maxNum > thre) {
                    return "";
                }
            }
        }
        char[] res = new char[len];
        int index = 0;
        while (countArray[maxCharIndex] > 0) {
            res[index] = (char) (maxCharIndex + 'a');
            index += 2;
            countArray[maxCharIndex]--;
        }
        for (int i = 0; i < countArray.length; i++) {
            while (countArray[i] > 0) {
                if (index >= len) {
                    index = 1;
                }
                res[index] = (char) (i + 'a');
                index += 2;
                countArray[i]--;
            }
        }
        return new String(res);
    }
}
