package com.shenghaishxt.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 有效的括号
 */
public class _0020 {
    public boolean isValid(String s) {
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
        System.out.println(new _0020().isValid("()")); //true
        System.out.println(new _0020().isValid("()[]{}")); //true
        System.out.println(new _0020().isValid("(]")); //false
        System.out.println(new _0020().isValid("([)]")); //false
        System.out.println(new _0020().isValid("{[]}")); //true
    }
}
