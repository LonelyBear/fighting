package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/30 10:42
 * @description https://interview.nowcoder.com/interview/15634624/interviewee?code=lj6MayKz 231. 2 的幂
 */

public class LeetCode231 {
    public boolean isPowerOfTwo(int n) {
        return n >= 1 && Integer.bitCount(n) == 1;
    }
}
