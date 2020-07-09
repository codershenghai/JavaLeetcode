package com.shenghaishxt.leetcode;

public class _0028_实现strStr {
    // 暴力法，这题还可以用KMP实现
    public int strStr(String haystack, String needle) {
        if (needle.equals("") || haystack.equals(needle)) return 0;
        for (int i = 0; i < haystack.length() && i+needle.length()-1 < haystack.length(); i++) {
            if (haystack.substring(i, i+needle.length()).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
