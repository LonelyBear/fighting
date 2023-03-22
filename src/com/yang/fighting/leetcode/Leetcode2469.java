package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/21 21:31
 * @description https://leetcode.cn/problems/convert-the-temperature/ 2469. 温度转换
 */
public class Leetcode2469 {
    public double[] convertTemperature(double celsius) {
        return new double[]{celsius + 273.15d, celsius * 1.80d + 32.00d};
    }
}
