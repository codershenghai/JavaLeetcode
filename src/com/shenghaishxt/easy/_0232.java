package com.shenghaishxt.easy;

import java.util.Stack;

class MyQueue {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        int res = outStack.pop();
        while (!outStack.empty()) {
            inStack.push(outStack.pop());
        }
        return res;
    }

    public int peek() {
        while (!inStack.empty()) {
            outStack.push(inStack.pop());
        }
        int res = outStack.peek();
        while (!outStack.empty()) {
            inStack.push(outStack.pop());
        }
        return res;
    }

    public boolean empty() {
        return inStack.empty();
    }
}

public class _0232{
    public static void main(String[] args) {
        MyQueue obj = new MyQueue();
        obj.push(1);
        obj.push(2);
        int param_2 = obj.pop();
        int param_3 = obj.peek();
        boolean param_4 = obj.empty();
        System.out.println(param_2);
        System.out.println(param_3);
        System.out.println(param_4);
    }
}

