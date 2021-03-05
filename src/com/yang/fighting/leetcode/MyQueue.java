package com.yang.fighting.leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author yangtao
 * @version 1.0
 * @date 2021/3/5 10:41
 * @description https://leetcode-cn.com/problems/implement-queue-using-stacks/ 232. 用栈实现队列
 */

public class MyQueue {

    private Deque<Integer> in;
    private Deque<Integer> out;

    /** Initialize your data structure here. */
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        in.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /** Get the front element. */
    public int peek() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return in.isEmpty() && out.isEmpty();
    }

}
