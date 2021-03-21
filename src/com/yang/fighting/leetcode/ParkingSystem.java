package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/19 15:49
 * @description https://leetcode-cn.com/problems/design-parking-system/ 1603. 设计停车系统
 */
public class ParkingSystem {

    private int big;
    private int medium;
    private int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        boolean res = false;
        switch (carType) {
            case 1:
                if (big > 0) {
                    big--;
                    res = true;
                }
                break;
            case 2:
                if (medium > 0) {
                    medium--;
                    res = true;
                }
                break;
            case 3:
                if (small > 0) {
                    small--;
                    res = true;
                }
                break;
            default:
                break;
        }
        return res;
    }
}
