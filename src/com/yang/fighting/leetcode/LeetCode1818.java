package com.yang.fighting.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/7/14 14:16
 * @description https://leetcode-cn.com/problems/minimum-absolute-sum-difference/ 1818. 绝对差值和
 */

public class LeetCode1818 {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int[][] absArray = new int[len][2];
        TreeSet<Integer> nums1Set = new TreeSet<>();
        long ans = 0;
        for (int i = 0; i < len; i++) {
            absArray[i][0] = i;
            absArray[i][1] = Math.abs(nums1[i] - nums2[i]);
            ans += absArray[i][1];
            nums1Set.add(nums1[i]);
        }
        if (ans == 0) return 0;
        Arrays.sort(absArray, (o1, o2) -> Integer.compare(o2[1], o1[1]));
        int maxAdjust = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            int[] pair = absArray[i];
            int index = pair[0];
            int num1 = nums1[index];
            int num2 = nums2[index];
            if (Math.abs(num1 - num2) <= maxAdjust) {
                break;
            }
            // 找到离 num2 最近的 nums1 的数
            Integer num1Low = nums1Set.floor(num2);
            Integer num1High = nums1Set.ceiling(num2);
            int absNum = Math.abs(num1 - num2);
            int absOldnum = absNum;
            if (num1Low != null) {
                absNum = Math.min(absNum, Math.abs(num1Low - num2));
            }
            if (num1High != null) {
                absNum = Math.min(absNum, Math.abs(num1High - num2));
            }
            if (absNum < absOldnum) {
                maxAdjust = Math.max(maxAdjust, (absOldnum - absNum));
            }
        }
        return (int)((ans - maxAdjust) % 1000000007);
    }
}
