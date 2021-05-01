package com.yang.fighting;


import com.yang.fighting.base.Employee;
import com.yang.fighting.base.ListNode;
import com.yang.fighting.base.TreeNode;
import com.yang.fighting.leetcode.*;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        LeetCode690 l = new LeetCode690();
        l.getImportance(Arrays.asList(new Employee(1, 5, Arrays.asList(2, 3)),
                new Employee(2, 3, Collections.emptyList()),
                new Employee(3, 3, Collections.emptyList())), 1);
    }
}
