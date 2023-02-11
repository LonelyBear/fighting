package com.yang.fighting.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2023/2/11 21:38
 * @description https://leetcode.cn/problems/design-authentication-manager/ 1797. 设计一个验证系统
 */
public class AuthenticationManager {

    private final Map<String, Integer> kv;
    private final Integer timeToLive;


    public AuthenticationManager(int timeToLive) {
        this.kv = new HashMap<>();
        this.timeToLive = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        kv.put(tokenId, currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        Integer time = kv.get(tokenId);
        if (time == null || time <= currentTime) {
            return;
        }
        kv.put(tokenId, currentTime + timeToLive);
    }

    public int countUnexpiredTokens(int currentTime) {
        List<Integer> sortTimes = kv.values().stream().sorted().collect(Collectors.toList());
        if (sortTimes.isEmpty()) {
            return 0;
        }
        if (currentTime >= sortTimes.get(sortTimes.size() - 1)) {
            return 0;
        }
        int cnt = 0;
        int i = sortTimes.size() - 1;
        while (i >= 0) {
            if (sortTimes.get(i) > currentTime) {
                cnt++;
                i--;
            } else {
                break;
            }
        }
        return cnt;
    }
}

/*
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
