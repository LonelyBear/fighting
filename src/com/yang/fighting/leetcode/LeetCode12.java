package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/5/14 21:02
 * @description https://leetcode-cn.com/problems/integer-to-roman/ 12. 整数转罗马数字
 */

public class LeetCode12 {

        private int num;
        int level;
        StringBuilder builder;

        public String intToRoman(int n) {
            // 1 <= num <= 3999
            builder = new StringBuilder();
            num = n;
            level = 1000;
            while (level != 0) {
                process(CharEnum.getLow(level), CharEnum.getMid(level), CharEnum.gethigh(level));
            }
            return builder.toString();
        }

        private void process( char low, char mid, char high) {
            if (num < level) {
                level = level / 10;
                return;
            }
            int cnt = 0;
            if (num >= 5 * level) {
                cnt = (num - 5 * level) / level;
                if (cnt > 3) {
                    for (int i = 0; i < 5 - cnt; i++) {
                        builder.append(low);
                    }
                    builder.append(high);
                } else {
                    builder.append(mid);
                    for (int i = 0; i < cnt; i++) {
                        builder.append(low);
                    }
                }
            } else {
                cnt = (num) / level;
                if (cnt > 3) {
                    for (int i = 0; i < 5 - cnt; i++) {
                        builder.append(low);
                    }
                    builder.append(mid);
                } else {
                    for (int i = 0; i < cnt; i++) {
                        builder.append(low);
                    }
                }
            }
                num = num % level;
            level = level / 10;
            return;
        }

        private enum CharEnum {
            I('I'),
            V('V'),
            X('X'),
            L('L'),
            C('C'),
            D('D'),
            M('M');
            char code;

            CharEnum(char code) {
                this.code = code;
            }

            public static char getLow(int level) {
                switch (level) {
                    case 1000:
                        return M.code;
                    case 100:
                        return C.code;
                    case 10:
                        return X.code;
                    case 1:
                        return I.code;
                    default:
                        return '0';
                }
            }

            public static char getMid(int level) {
                switch (level) {
                    case 100:
                        return D.code;
                    case 10:
                        return L.code;
                    case 1:
                        return V.code;
                    default:
                        return '0';
                }
            }

            public static char gethigh(int level) {
                switch (level) {
                    case 100:
                        return M.code;
                    case 10:
                        return C.code;
                    case 1:
                        return X.code;
                    default:
                        return '0';
                }
            }

        }
}
