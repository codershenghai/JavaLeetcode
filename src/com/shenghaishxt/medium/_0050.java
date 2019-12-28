package com.shenghaishxt.medium;

public class _0050 {
    /**
     * 快速幂算法
     * 对于n是偶数的情况，x^n = x^(n/2) * x^(n/2)
     * 对于n是奇数的情况，x^n = x^(n/2) * x(n/2) * x
     */
    private double myPow(double x, int n) {
        return n < 0 ? fastPow(1/x, -n) : fastPow(x, n);
    }

    private double fastPow(double x, int n) {
        // 递归终止的条件
        if (n == 0) return 1.0;
        // 找返回值
        double half = fastPow(x, n/2);
        // 本级递归应该做什么
        return n%2==0 ? half*half : half*half*x;
    }

    public static void main(String[] args) {
        _0050 Sol = new _0050();
        double x = 2.1000;
        int n = 3;
        double res = Sol.myPow(x, n);
        System.out.println(res);
    }
}
