package com.yang.fighting.leetcode;

import java.util.List;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/23 19:12
 * @description
 */

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

   // @return the nested list that this NestedInteger holds, if it holds a nested list
   // Return null if this NestedInteger holds a single integer
   public List<NestedInteger> getList();

}
