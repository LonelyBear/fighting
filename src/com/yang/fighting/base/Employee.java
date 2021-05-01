package com.yang.fighting.base;

import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/1 18:36
 * @description
 */

public class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
