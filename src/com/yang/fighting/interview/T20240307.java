package com.yang.fighting.interview;


/**
 * @author yangtao
 * @version 1.0
 * @date 2024/3/7 20:32
 * @description
 */
public class T20240307 {

    public static long findMaxNum(String input) {
        if (input == null || input.length() == 0) {
            return 0;
        }
        char[] array = input.toCharArray();
        long ans = 0;
        boolean find = false;
        StringBuilder stringBuilder = null;
        for (char c : array) {
            if (c < '0' || c > '9') {
                if (find) {
                    ans = Math.max(ans, Long.parseLong(stringBuilder.toString()));
                    find = false;
                    continue;
                } else {
                    continue;
                }
            }
            if (!find) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                find = true;
            } else {
                stringBuilder.append(c);
            }
        }
        if (find) {
            ans = Math.max(ans, Long.parseLong(stringBuilder.toString()));
        }
        return ans;
    }

    public static void main(String[] args) {
        // write your code here
        long ans = findMaxNum("ab12cd45ef3g1");
        System.out.println("ans=" + ans);

    }
}
