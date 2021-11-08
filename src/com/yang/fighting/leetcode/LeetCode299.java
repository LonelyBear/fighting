package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/11/8 22:55
 * @description
 */
public class LeetCode299 {
    public String getHint(String secret, String guess) {
        int[] origin = new int[10];
        int[] dest = new int[10];
        if (secret.length() == 0) {
            return "0A0B";
        }
        int aNum = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                aNum++;
                continue;
            }
            origin[secret.charAt(i) - '0'] ++;
            dest[guess.charAt(i) - '0']++;
        }
        int bNum = 0;
        for (int i = 0; i < origin.length; i++) {
            bNum += Math.min(origin[i], dest[i]);
        }
        return aNum + "A" + bNum + "B";
    }
}
