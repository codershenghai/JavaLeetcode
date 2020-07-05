package com.shenghaishxt.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Stack;

public class _0020_有效的括号 {
    private boolean isValid1(String s) {
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        char[] chars = s.toCharArray();
        for (char i : chars) {
            if (!stack.empty() && map.containsKey(stack.peek()) && i == map.get(stack.peek()))
                stack.pop();
            else stack.push(i);
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (!deque.isEmpty() && (deque.peek() == '(' && s.charAt(i) == ')' ||
                    deque.peek() == '[' && s.charAt(i) == ']' ||
                    deque.peek() == '{' && s.charAt(i) == '}')) deque.poll();
            else deque.push(s.charAt(i));
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        _0020_有效的括号 Sol = new _0020_有效的括号();
        System.out.println(Sol.isValid2("(]"));
    }
}
