package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2020/12/20 15:11
 * @description https://leetcode-cn.com/problems/remove-duplicate-letters/
 */

public class LeetCode316 {
    public String removeDuplicateLetters(String s) {
        if (s.length() == 0) {
            return null;
        }
        System.out.println("String is " + s);
        boolean[] exist = new boolean[26];
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        // 优化点: 可以使用StringBuffer
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (!exist[c - 'a']) {
                while (queue.size() > 0 && queue.peekLast() > c) {
                    if (count[queue.peekLast() - 'a'] > 0) {
                        exist[queue.peekLast() - 'a'] = false;
                        System.out.println("pull char is " + queue.peekLast());
                        queue.pollLast();
                    } else {
                        break;
                    }
                }
                System.out.println("offer char is " + c);
                queue.offer(c);
                exist[c - 'a'] = true;
            }
            count[c - 'a']--;
        }
        Iterator<Character> iterator = queue.iterator();
        StringBuilder builder = new StringBuilder();
        while (iterator.hasNext()) {
            builder.append(iterator.next());
        }
        return builder.toString();
    }


//    public String removeDuplicateLetters(String s) {
//        boolean[] vis = new boolean[26];
//        int[] num = new int[26];
//        for (int i = 0; i < s.length(); i++) {
//            num[s.charAt(i) - 'a']++;
//        }
//        System.out.println("String is " + s);
//        StringBuffer sb = new StringBuffer();
//        for (int i = 0; i < s.length(); i++) {
//            char ch = s.charAt(i);
//            if (!vis[ch - 'a']) {
//                while (sb.length() > 0 && sb.charAt(sb.length() - 1) > ch) {
//                    if (num[sb.charAt(sb.length() - 1) - 'a'] > 0) {
//                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
//                        System.out.println("pull char is " + sb.charAt(sb.length() - 1));
//                        sb.deleteCharAt(sb.length() - 1);
//                    } else {
//                        break;
//                    }
//                }
//                vis[ch - 'a'] = true;
//                System.out.println("offer char is " + ch);
//                sb.append(ch);
//            }
//            num[ch - 'a'] -= 1;
//        }
//        return sb.toString();
//    }

}
