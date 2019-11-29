package com.shenghaishxt.easy;

public class _0009 {
    private boolean isPalindrome(int x) {
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
        _0009 Sol = new _0009();
        boolean res = Sol.isPalindrome(10);
        System.out.println(res);
    }
}
