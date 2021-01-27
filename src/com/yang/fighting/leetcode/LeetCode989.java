package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/22 11:44
 * @description https://leetcode-cn.com/problems/add-to-array-form-of-integer/ 989. 数组形式的整数加法
 */

public class LeetCode989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        if (K == 0) {
            return trans(A);
        }
        List<Integer> array1 = trans(A);
        List<Integer> array2 = trans(K);
        return mergeArray(array1, array2);
    }

    private List<Integer> trans(int[] nums) {
        List<Integer> res = new ArrayList<>(nums.length);
        for (int num : nums) {
            res.add(num);
        }
        return res;
    }

    private List<Integer> trans(int num) {
        List<Integer> res = new ArrayList<>();
        while (num != 0) {
            res.add(num % 10);
            num = num / 10;
        }
        Collections.reverse(res);
        return res;
    }

    private List<Integer> mergeArray(List<Integer> array1, List<Integer> array2) {
        int len1 = array1.size();
        int len2 = array2.size();
        boolean up = false;
        int common = Math.min(len1, len2);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < common ; i++) {
            int index1 = len1 - 1 - i;
            int index2 = len2 - 1 - i;
            int sum = array1.get(index1) + array2.get(index2) + (up ? 1 : 0);
            up = sum > 9;
            res.add(sum % 10);
        }
        if (len1 > len2) {
            for (int i = common; i < len1; i++) {
                int sum = array1.get(len1 - 1 - i) + (up ? 1 : 0);
                up = sum > 9;
                res.add(sum % 10);
            }
        } else {
            for (int i = common; i < len2; i++) {
                int sum = array2.get(len2 - 1 - i) + (up ? 1 : 0);
                up = sum > 9;
                res.add(sum % 10);
            }
        }
        if (up) {
            res.add(1);
        }
        Collections.reverse(res);
        return res;
    }
}
