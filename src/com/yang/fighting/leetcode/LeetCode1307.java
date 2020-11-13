package com.yang.fighting.leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/28 10:29
 * @description https://leetcode-cn.com/problems/verbal-arithmetic-puzzle/
 */

public class LeetCode1307 {
    /**
     * 所有的组合情况
     */
    int[][] complex = new int[3628800][11];
    int count = 0;

    public boolean isSolvable(String[] words, String result) {
        // 先统计有多少个不同字符
        Set<Character> set = new HashSet<>();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                set.add(word.charAt(j));
            }
        }
        int charSize = set.size();
        // 排列组合??  -- C 10 charSize
        //Map<Character, Integer> map = new HashMap<>(charSize);
        for (int i = 0; i < charSize; i++) {

        }


        return false;
    }

    private void processComplex(int[][] complex, Set<Character> set, int itr) {
        if (itr == 1) {
            complex[count][0] = 1;

            return;
        }
        processComplex(complex, set , itr - 1);
    }


    private int transToNum(String word, Map<Character, Integer> map) {
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            res = res * 10 + map.get(word.charAt(i));
        }
        return res;
    }
}
