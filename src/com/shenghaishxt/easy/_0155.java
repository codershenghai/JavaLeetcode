package com.shenghaishxt.easy;

import java.util.Stack;

/*      使用辅助栈：

        入栈 3
        |   |    |   |
        |   |    |   |
        |_3_|    |_3_|
        stack  minStack

        入栈 5 ， 5 大于 minStack 栈顶，不处理
        |   |    |   |
        | 5 |    |   |
        |_3_|    |_3_|
        stack  minStack

        入栈 2 ，此时右边的 minStack 栈顶就保存了当前最小值 2
        | 2 |    |   |
        | 5 |    | 2 |
        |_3_|    |_3_|
        stack  minStack

        出栈 2，此时右边的 minStack 栈顶就保存了当前最小值 3
        |   |    |   |
        | 5 |    |   |
        |_3_|    |_3_|
        stack  minStack

        出栈 5，右边 minStack 不处理
        |   |    |   |
        |   |    |   |
        |_3_|    |_3_|
        stack  minStack

        出栈 3
        |   |    |   |
        |   |    |   |
        |_ _|    |_ _|
        stack  minStack*/

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> assist_stack;

    MinStack() {
        stack = new Stack<>();
        assist_stack = new Stack<>();
    }

    void push(int x) {
        if (stack.empty() || x <= assist_stack.peek()) {
            stack.push(x);
            assist_stack.push(x);
        } else {
            stack.push(x);
        }
    }

    void pop() {
        if (stack.peek().equals(assist_stack.peek())) {
            stack.pop();
            assist_stack.pop();
        } else stack.pop();
    }

    int top() {
        return stack.peek();
    }

    int getMin() {
        return assist_stack.peek();
    }

}

public class _0155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
