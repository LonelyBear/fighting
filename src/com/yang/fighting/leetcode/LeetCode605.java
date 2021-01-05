package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/1/2 23:10
 * @description https://leetcode-cn.com/problems/can-place-flowers/ 605-种花问题
 */

public class LeetCode605 {
    /**
     * 数学归纳法
     * @param flowerbed
     * @param n
     * @return
     */
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int head = 0, tail = 0, mid = 0, canOperate = 0, index = 0, left = 0, right = 0;
        while (index < flowerbed.length && flowerbed[index] != 1) {
            head++;
            index++;
        }
        left = index;
        // 特殊处理一下全零的情况
        if (left >= flowerbed.length) {
            return Math.ceil((double) head / 2d) >= n;
        }
        canOperate += head / 2;
        index = flowerbed.length - 1;
        while (index > left && flowerbed[index] != 1) {
            tail++;
            index--;
        }
        right = index;
        canOperate += tail / 2;
        int tmp = 0;
        for (index = left + 1;  index <= right ; index++) {
            if (flowerbed[index] != 1) {
                tmp++;
            } else {
                canOperate += (tmp >= 3) ? Math.ceil(((double) tmp) / 2d - 1) : 0;
                tmp = 0;
            }
        }
        return canOperate >= n;
    }


    /**
     * 题解中改进的数学归纳法: 左右两端进行补零操作
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowersV2(int[] flowerbed, int n) {
        if (flowerbed == null || flowerbed.length == 0) {
            return n == 0;
        }

        // 当前全0区段中连续0的数量，刚开始预设1个0，因为开头花坛的最左边没有花，可以认为存在一个虚无的0
        int countOfZero = 1;
        // 可以种的花的数量
        int canPlace = 0;
        for (int bed : flowerbed) {
            // 遇到0，连续0的数量+1
            if (bed == 0) {
                countOfZero++;
            } else {
                // 遇到1，结算上一段连续的0区间，看能种下几盆花：(countOfZero-1)/2
                canPlace += (countOfZero-1)/2;
                if (canPlace >= n) {
                    return true;
                }
                // 0的数量清零，开始统计下一个全0分区
                countOfZero = 0;
            }
        }
        // 最后一段0区还未结算：
        // 最后再预设1个0，因为最后花坛的最右边没有花，可以认为存在一个虚无的0
        countOfZero++;
        canPlace += (countOfZero-1)/2;

        return canPlace >= n;
    }
}
