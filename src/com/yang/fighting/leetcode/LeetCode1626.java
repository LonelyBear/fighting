package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/3/22 22:18
 * @description https://leetcode.cn/problems/best-team-with-no-conflicts/ 1626. 无矛盾的最佳球队
 */
public class LeetCode1626 {

    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            players.add(new Player(ages[i], scores[i]));
        }
        Collections.sort(players);
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (players.get(j).getAge() <= players.get(i).getAge()) {
                    tmp = Math.max(tmp, dp[j]);
                }
            }
            dp[i] = tmp + players.get(i).getScore();
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    private static class Player implements Comparable<Player> {
        private final int age;
        private final int score;

        public Player(int age, int score) {
            this.age = age;
            this.score = score;
        }

        public int getAge() {
            return age;
        }
        public int getScore() {
            return score;
        }

        @Override
        public int compareTo(Player other) {
            return this.score == other.score
                    ? Integer.compare(this.age, other.age)
                    : Integer.compare(this.score, other.score);
        }
    }
}
