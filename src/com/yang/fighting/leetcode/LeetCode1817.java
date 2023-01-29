package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @date 2023/1/20 09:39
 * @description https://leetcode.cn/problems/finding-the-users-active-minutes/ 1817. 查找用户活跃分钟数
 */
public class LeetCode1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> userActiveTimeMap = new HashMap<>();
        for (int[] log : logs) {
            int userId = log[0];
            int userActiveTime = log[1];
            if (userActiveTimeMap.containsKey(userId)) {
                userActiveTimeMap.get(userId).add(userActiveTime);
            } else {
                Set<Integer> timeSet = new HashSet<>();
                timeSet.add(userActiveTime);
                userActiveTimeMap.put(userId, timeSet);
            }
        }
        Map<Integer, Integer> timeCountMap = new HashMap<>();
        for(Map.Entry<Integer, Set<Integer>> userActiveTimeEntry : userActiveTimeMap.entrySet()) {
            ans[userActiveTimeEntry.getValue().size()- 1] ++;
        }
        return ans;
    }
}
