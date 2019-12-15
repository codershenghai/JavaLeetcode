package com.shenghaishxt.medium;

public class _0064 {
    private int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];

        // 初始化
        for (int i = 1; i < m; i++)
            f[i][0] = f[i-1][0] + grid[i][0];
        for (int j = 1; j < n; j++)
            f[0][j] = f[0][j-1] + grid[0][j];

        // f[i][j] = min(f[i-1][j], f[i][j-1]) + grid[i][j]
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];

        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        _0064 Sol = new _0064();
        int[][] grid = new int[][] {{1,3,1}, {1,5,1}, {4,2,1}};
        System.out.println(Sol.minPathSum(grid));
    }
}
