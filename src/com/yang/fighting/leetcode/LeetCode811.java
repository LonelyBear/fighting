package com.yang.fighting.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author yangtao
 * @version 1.0
 * @date 2022/10/5 19:12
 * @description https://leetcode.cn/problems/subdomain-visit-count/ 811. 子域名访问计数
 */
public class LeetCode811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains.length == 0) {
            return new ArrayList<>(2);
        }
        Map<String, Integer> domainCntMap = new HashMap<>();
        for (String cpdomain : cpdomains) {
            String[] kv = cpdomain.split(" ");
            if (kv.length == 2) {
                int cnt = Integer.parseInt(kv[0]);
                String[] domains = kv[1].split("\\.");
                String domain = "";
                for (int i = domains.length - 1; i >= 0 ; i--) {
                    if (i == domains.length - 1) {
                        domain = domains[i];
                    } else {
                        domain = domains[i] + "." + domain;
                    }
                    domainCntMap.merge(domain, cnt, Integer::sum);
                }
            }
        }
        return domainCntMap.entrySet().stream()
                .map(entry -> entry.getValue() + " " + entry.getKey())
                .collect(Collectors.toList());
    }
}
