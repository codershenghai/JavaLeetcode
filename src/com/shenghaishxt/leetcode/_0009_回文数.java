package com.shenghaishxt.leetcode;

public class _0009_回文数 {
    // 将x倒序，检查倒序的x和原来的x是否相等
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int num = x;
        int cur = 0;
        while (num > 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return x == cur;
    }

    public static void main(String[] args) {
        _0009_回文数 Sol = new _0009_回文数();
        boolean res = Sol.isPalindrome(10);
        System.out.println(res);
    }
}
