package com.shenghaishxt.easy;

public class _0070 {
    private int climbStairs(int n) {
        if (n <= 1)
            return n;

        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;
        f[2] = 2;

        // f[i] = f[i-1] + f[i-2]
        for (int i = 3; i <= n; i++) {
            f[i] = f[i-1] + f[i-2];
        }
        return f[n];
    }

    public static void main(String[] args) {
        _0070 Sol = new _0070();
        System.out.println(Sol.climbStairs(1));
    }
}
