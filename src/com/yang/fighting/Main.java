package com.yang.fighting;


import com.yang.fighting.base.Employee;
import com.yang.fighting.base.ListNode;
import com.yang.fighting.base.TreeNode;
import com.yang.fighting.leetcode.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        LCP07 l = new LCP07();
        l.numWays(5,
                new int[][]{new int[]{0, 2}, new int[]{2, 1}, new int[]{3, 4}, new int[]{2, 3}, new int[]{1, 4}, new int[]{2, 0}, new int[]{0, 4}},
                3);
    }
}
