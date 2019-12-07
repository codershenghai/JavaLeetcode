package com.shenghaishxt.easy;

public class _0172 {
    // https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
    private int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        _0172 Sol = new _0172();
        System.out.println(Sol.trailingZeroes(5));
    }
}
