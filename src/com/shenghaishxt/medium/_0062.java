package com.shenghaishxt.medium;

public class _0062 {
    private int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];

        // f[i][j] = f[i-1][j] + f[i][j-1]
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    f[i][j] = 1;
                else f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        _0062 Sol = new _0062();
        System.out.println(Sol.uniquePaths(7, 3));
    }
}
