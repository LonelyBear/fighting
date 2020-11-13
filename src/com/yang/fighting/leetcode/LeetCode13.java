package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/10/28 17:12
 * @description https://leetcode-cn.com/problems/roman-to-integer/
 */

public class LeetCode13 {
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (i != chars.length - 1) {
                // 比较后一位和前一位的优先级
                if (CharEnum.findByCode(s.charAt(i)).getLevel() < CharEnum.findByCode(s.charAt(i + 1)).getLevel()) {
                    res = res - CharEnum.findByCode(s.charAt(i)).getValue();
                } else {
                    res = res + CharEnum.findByCode(s.charAt(i)).getValue();
                }
            } else {
                res = res + CharEnum.findByCode(s.charAt(i)).getValue();
            }
        }
        return res;
    }

    private enum CharEnum {
        I('I', 1, 0),
        V('V', 5, 1),
        X('X', 10, 2),
        L('L', 50, 3),
        C('C', 100, 4),
        D('D', 500, 5),
        M('M', 1000, 6);
        char code;
        int value;
        int level;

        CharEnum(char code, int value, int level) {
            this.code = code;
            this.value = value;
            this.level = level;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public char getCode() {
            return code;
        }

        public void setCode(char code) {
            this.code = code;
        }

        private static Map<Character, CharEnum> map = new HashMap<>();

        static {
            CharEnum[] values = values();
            for (CharEnum ele : values) {
                map.put(ele.code, ele);
            }
        }

        public static CharEnum findByCode(Character code) {
            return map.get(code);
        }
    }
}
