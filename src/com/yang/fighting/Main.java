package com.yang.fighting;


import com.yang.fighting.leetcode.*;
import com.yang.fighting.base.*;
import com.yang.fighting.sort.*;

import java.net.SocketException;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws SocketException {
//        // write your code here
        LeetCode1125 code = new LeetCode1125();
        String[] req_skills = new String[] {"algorithms","math","java","reactjs","csharp","aws"};
        List<List<String>> people = Arrays.asList(Arrays.asList("algorithms","math","java"),
                Arrays.asList("algorithms","math","reactjs"),
                Arrays.asList("java","csharp","aws"),
                Arrays.asList("reactjs","csharp"),
                Arrays.asList("csharp","math"),
                Arrays.asList("aws","java"));
        System.out.println(Arrays.toString(code.smallestSufficientTeam(req_skills, people)));
    }
}
