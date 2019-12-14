package com.shenghaishxt.medium;

public class _0063 {
    private int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1)
            return 0;
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] f = new int[m][n];

        /**
         *              1,                      if i==0,j==0
         *              0,                      if obstacleGrid[i][j]==1
         * f[i][j] =    f[i][j-1],              if i==0
         *              f[i-1][j],              if j==0
         *              f[i-1][j] + f[i][j-1],  if 其他
         */
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i==0 && j==0)
                    f[i][j] = 1;
                else if (obstacleGrid[i][j] == 1)
                    f[i][j] = 0;
                else if (i == 0)
                    f[i][j] = f[i][j-1];
                else if (j == 0)
                    f[i][j] = f[i-1][j];
                else
                    f[i][j] = f[i-1][j] + f[i][j-1];
            }
        }
        return f[m-1][n-1];
    }

    public static void main(String[] args) {
        _0063 Sol = new _0063();
        int res = Sol.uniquePathsWithObstacles(new int[][] {{1}});
        System.out.println(res);
    }
}
