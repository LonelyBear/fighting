package com.yang.fighting.leetcode;

import com.yang.fighting.base.Employee;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/1 18:36
 * @description https://leetcode-cn.com/problems/employee-importance/ 690. 员工的重要性
 */

public class LeetCode690 {

    private int result;

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(v -> v.id, v -> v));
        result = 0;
        process(id, map);
        return result;
    }

    private void process(int id, Map<Integer, Employee> map) {
        result += map.get(id).importance;
        if (map.get(id).subordinates.size() != 0) {
            map.get(id).subordinates.forEach(uid -> process(uid, map));
        }
    }
}
