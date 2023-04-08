package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/8 21:42
 * @description https://leetcode.cn/problems/smallest-sufficient-team/ 1125. 最小的必要团队
 */
public class LeetCode1125V2 {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        Map<String, Integer> skillIndexMap = new HashMap<>();
        int skillLen = req_skills.length;
        int peopleLen = people.size();
        for (int i = 0; i < skillLen; i++) {
            skillIndexMap.put(req_skills[i], i);
        }
        // 用二进制 作为技能点 有点bitmap的味道
        List<Integer>[] dp = new List[1 << skillLen];
        dp[0] = new ArrayList<>();
        for (int i = 0; i < peopleLen; i++) {
            int curPeopleKill = 0;
            List<String> peopleSkillList = people.get(i);
            for (String skill : peopleSkillList) {
                curPeopleKill |= (1 << skillIndexMap.get(skill));
            }
            for (int j = 0; j < dp.length; j++) {
                if (dp[j] == null) {
                    continue;
                }
                int combine = curPeopleKill | j;
                if (dp[combine] == null || Objects.requireNonNull(dp[j]).size() + 1 < dp[combine].size()) {
                    dp[combine] = new ArrayList<>(dp[j]);
                    dp[combine].add(i);
                }
            }
        }
        return dp[(1 << skillLen) - 1].stream().mapToInt(e -> e).toArray();
    }
}
