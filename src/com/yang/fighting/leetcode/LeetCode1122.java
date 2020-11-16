package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/11/14 09:55
 * @description https://leetcode-cn.com/problems/relative-sort-array/
 */

public class LeetCode1122 {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        if (arr1.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> indexMap = new HashMap<>(arr2.length);
        for (int i = 0; i < arr2.length; i++) {
            indexMap.put(arr2[i], i);
        }
        List<Integer> list = new ArrayList<>(arr1.length);
        for (int j : arr1) {
            list.add(j);
        }
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (!indexMap.containsKey(o1) && !indexMap.containsKey(o2)) {
                    return o1 > o2 ? 1 : (o1.equals(o2) ? 0 : -1);
                }
                if (!indexMap.containsKey(o1) && indexMap.containsKey(o2)) {
                    return 1;
                }
                if (indexMap.containsKey(o1) && !indexMap.containsKey(o2)) {
                    return -1;
                }
                if (indexMap.containsKey(o1) && indexMap.containsKey(o2)) {
                    int x = indexMap.get(o1);
                    int y = indexMap.get(o2);
                    return Integer.compare(x, y);
                }
                return 0;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            arr1[i] = list.get(i);
        }
        return arr1;
    }
}
