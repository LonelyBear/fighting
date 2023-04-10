package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/9 12:30
 * @description https://leetcode.cn/problems/sum-of-distances/submissions/ 6360. 等值距离和
 */
public class LeetCode6360 {
    public long[] distance(int[] nums) {
        Map<Integer, List<Integer>> valIndexListMap = new HashMap<>();
        int len = nums.length;
        for(int i = 0; i < len; i++) {
            int val = nums[i];
            if(valIndexListMap.get(val) != null) {
                valIndexListMap.get(val).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                valIndexListMap.put(val, list);
            }
        }
        long[] ans = new long[len];
        for (Map.Entry<Integer, List<Integer>> entry : valIndexListMap.entrySet()) {
            if (entry.getValue().size() == 1) {
                ans[entry.getValue().get(0)] = 0;
            } else {
                List<Integer> list = entry.getValue();
                long[] result = getResult(list);
                for (int i = 0; i < list.size(); i++) {
                    ans[list.get(i)] = result[i];
                }
            }
        }

        return ans;
    }


    private long[] getResult(List<Integer> nums) {
        int len = nums.size();
        long[] prefixArray = new long[len];
        prefixArray[0] = (long) nums.get(0);
        for (int i = 1; i < len; i++) {
            prefixArray[i] = prefixArray[i - 1] + (long) nums.get(i);
        }
        long[] ans = new long[len];
        ans[0] = prefixArray[len - 1] - prefixArray[0] - (long) (len - 1) * nums.get(0);
        ans[len - 1] = (long) (len - 1) * nums.get(len - 1) - prefixArray[len - 2];
        for (int i = 1; i < len - 1; i++) {
            ans[i] = ((long) i * nums.get(i)) - (prefixArray[i - 1])
                    + (prefixArray[len - 1] - prefixArray[i]) - (long) (len - 1 - i) * nums.get(i);
        }
        return ans;
    }
}
