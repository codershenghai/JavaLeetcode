package com.shenghaishxt.leetcode;

public class _0050_Pow {
    /**
     * 同剑指offer 16
     */
    public double myPow(double x, int n) {
        return n < 0 ? fastPow(1/x, -n) : fastPow(x, n);
    }

    public double fastPow(double x, int n) {
        // 递归终止的条件
        if (n == 0) return 1.0;
        // 找返回值
        double half = fastPow(x, n/2);
        // 本级递归应该做什么
        return n%2==0 ? half*half : half*half*x;
    }

    public static void main(String[] args) {
        System.out.println(new _0050_Pow().myPow(2.00000, 10));
    }
}
