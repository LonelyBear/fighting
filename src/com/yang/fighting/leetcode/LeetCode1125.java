package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/4/8 19:43
 * @description https://leetcode.cn/problems/smallest-sufficient-team/ 1125. 最小的必要团队
 */
public class LeetCode1125 {

    private Map<String, Set<Integer>> skillPeopleMap;
    private List<List<String>> peopleSkillList;
    private int minCnt;
    private int[] minResult;
    private Set<Integer> selectSet;
    private Set<String> selectSkillSet;
    private Map<String, Integer> selectSkillCntMap;
    private String[] req_skills;
    private int len;

    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        long start = System.currentTimeMillis();
        peopleSkillList = people;
        skillPeopleMap = new HashMap<>();
        for (int i = 0; i < people.size(); i++)  {
            List<String> single = people.get(i);
            for (String skill : single) {
                if (!skillPeopleMap.containsKey(skill)) {
                    skillPeopleMap.put(skill, new HashSet<>());
                }
                skillPeopleMap.get(skill).add(i);
            }
        }
        minCnt = Integer.MAX_VALUE;
        selectSet = new HashSet<>();
        selectSkillSet = new HashSet<>();
        selectSkillCntMap = new HashMap<>();
        this.req_skills = req_skills;
        len = req_skills.length;
        process(0);
        System.out.println("======= cost =" + (System.currentTimeMillis() - start));
        return minResult;
    }

    private void process(int index) {
        if (index >= len) {
            if (selectSet.size() < minCnt && selectSkillSet.size() == len) {
                minCnt = selectSet.size();
                minResult = buildResult(selectSet);
            }
            return;
        }
        if (selectSkillSet.contains(req_skills[index])) {
            process(index + 1);
            return;
        }
        Set<Integer> peopleSet = skillPeopleMap.get(req_skills[index]);
        for (int people : peopleSet) {
            List<String> skills = peopleSkillList.get(people);
            selectSet.add(people);
            for (String skill : skills) {
                selectSkillSet.add(skill);
                selectSkillCntMap.merge(skill, 1, Integer::sum);
            }
            process(index + 1);
            selectSet.remove(people);
            for (String skill : skills) {
                selectSkillCntMap.put(skill, selectSkillCntMap.get(skill) - 1);
                if (selectSkillCntMap.get(skill) == 0) {
                    selectSkillSet.remove(skill);
                }
            }
        }
    }

    private int[] buildResult(Set<Integer> selectSet) {
        int[] res = new int[selectSet.size()];
        int i = 0;
        for (Integer num : selectSet) {
            res[i] = num;
            i++;
        }
        return res;
    }
}
