package com.yang.fighting.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/19 22:31
 * @description https://leetcode.cn/problems/number-of-students-unable-to-eat-lunch/ 1700. 无法吃午餐的学生数量
 */
public class LeetCode1700 {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> studentQ = new LinkedList<>();
        Queue<Integer> cakeQ = new LinkedList<>();
        for (int i = 0; i < sandwiches.length; i++) {
            studentQ.offer(students[i]);
            cakeQ.offer(sandwiches[i]);
        }
        int aliveNum = students.length;
        int count = 0;
        while (count <= aliveNum) {
            if (studentQ.isEmpty() || cakeQ.isEmpty()) {
                return 0;
            }
            count++;
            int studentVal = studentQ.poll();
            if (studentVal == cakeQ.peek()) {
                count = 0;
                cakeQ.poll();
            } else {
                studentQ.offer(studentVal);
            }
        }
        return studentQ.size();
    }
}
