package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/2/7 09:22
 * @description https://leetcode-cn.com/problems/non-decreasing-array/ 665. 非递减数列
 */

public class LeetCode665 {
    public boolean checkPossibility(int[] nums) {
        /*
         * 贪心算法:
         * 判断 num[i] 是否小于 num[i - 1]
         * 当 i = 1，那么修改 num[i - 1]，不要动 nums[i]，因为nums[i]后面的元素是啥我们还不知道呢，少动它为妙。
         * 当 i > 1，我们应该优先考虑把 nums[i - 1]调小到 >= nums[i - 2] 并且 <= nums[i]。同样尽量不去修改 nums[i]，理由同上。
         * 当 i > 1 且 nums[i] < nums[i - 2]，我们无法调整 nums[i - 1]，我们只能调整 nums[i] 到 nums[i - 1]。
         */
        int len = nums.length;
        boolean hasModify = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                if (hasModify) {
                    return false;
                }
                hasModify = true;
                if (i == 1) {
                    nums[i - 1] = nums[i];
                } else if (nums[i] < nums[i - 2]) {
                    nums[i] = nums[i - 1];
                } else {
                    nums[i - 1] = nums[i -2];
                }
            }
        }
        return true;
    }
}
