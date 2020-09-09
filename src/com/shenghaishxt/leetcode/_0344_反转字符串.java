package com.shenghaishxt.leetcode;

public class _0344_反转字符串 {
    public static void reverseString(char[] s) {
        int left = 0, right = s.length-1;
        while (left < right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        reverseString(s);
        System.out.println(s);
    }
}
