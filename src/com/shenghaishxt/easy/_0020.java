package com.shenghaishxt.easy;

import java.util.HashMap;
import java.util.Stack;

public class _0020 {
    private boolean isValid(String s) {
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

    public static void main(String[] args) {
        _0020 Sol = new _0020();
        System.out.println(Sol.isValid("(]"));
    }
}
