package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @date 2023/1/19 20:12
 * @description https://leetcode.cn/problems/count-integers-with-even-digit-sum/ 2180. 统计各位数字之和为偶数的整数个数
 */
public class LeetCode2180 {
    public int countEven(int num) {
        int res = 0;
        for (int i = 1; i <= num; i++) {
            if (isEven(i)) {
                res++;
            }
        }
        return res;
    }

    private boolean isEven(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num / 10;
        }
        return sum % 2 == 0;
    }
    

}
