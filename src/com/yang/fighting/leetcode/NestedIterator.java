package com.yang.fighting.leetcode;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/23 19:11
 * @description https://leetcode-cn.com/problems/flatten-nested-list-iterator/ 341. 扁平化嵌套列表迭代器
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class NestedIterator implements Iterator<Integer> {

    List<Integer> list;
    Iterator<Integer> iterator;

    public NestedIterator(List<NestedInteger> nestedList) {
        list = new LinkedList<>();
        init(nestedList, list);
        iterator = list.listIterator();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /**
     * object - init
     * @param nestedList
     */
    private void init(List<NestedInteger> nestedList, List<Integer> data) {
        for (NestedInteger nestedInteger : nestedList) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                List<Integer> tmp = new LinkedList<>();
                init(nestedInteger.getList(), tmp);
                list.addAll(tmp);
            }
        }
    }
}


