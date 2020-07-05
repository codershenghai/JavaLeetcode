package com.shenghaishxt.leetcode;

import java.util.Arrays;

public class _0014_最长公共前缀 {
    // 排序数组，比较第一个单词和最后一个单词，看有多少前缀相同。
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        Arrays.sort(strs);
        char[] a = strs[0].toCharArray();
        char[] b = strs[strs.length-1].toCharArray();
        for (int i = 0; i < a.length; i++) {
            if (i < b.length && a[i] == b[i]) sb.append(a[i]);
            else break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        _0014_最长公共前缀 Sol = new _0014_最长公共前缀();
        String res = Sol.longestCommonPrefix(new String[]{"flower","flow","flight"});
        System.out.println(res);
    }
}
