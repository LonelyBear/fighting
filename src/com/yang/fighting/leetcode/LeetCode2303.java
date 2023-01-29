package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yangtao
 * @date 2023/1/23 14:42
 * @description https://leetcode.cn/problems/calculate-amount-paid-in-taxes/ 2303. 计算应缴税款总额
 */
public class LeetCode2303 {
    public double calculateTax(int[][] brackets, int income) {
        return taxCalculatorList(brackets, income).stream()
                .mapToDouble(TaxCalculator::taxResult)
                .sum();
    }

    private static class TaxCalculator {
        private final int amount;
        private final double bizRate;

        public TaxCalculator(int amount, double bizRate) {
            this.amount = amount;
            this.bizRate = bizRate;
        }

        private double taxResult() {
            return bizRate * amount;
        }
    }

    private List<TaxCalculator> taxCalculatorList(int[][] brackets, int income) {
        List<TaxCalculator> result = new ArrayList<>();
        if (brackets.length == 0) {
            return result;
        }
        int last = 0;
        for (int[] bracket : brackets) {
            double bizRate = (double) bracket[1] / (double) 100;
            if (income >= bracket[0]) {
                result.add(new TaxCalculator(bracket[0] - last, bizRate));
                last = bracket[0];
            } else {
                result.add(new TaxCalculator(income - last, bizRate));
                break;
            }
        }
        return result;
    }

}

