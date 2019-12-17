package com.shenghaishxt.easy;

import java.util.ArrayList;
import java.util.List;

public class _0119 {
    private List<Integer> getRow(int rowIndex) {
        List<List<Integer>> dp = new ArrayList<>();

        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else row.add(dp.get(i-1).get(j-1) + dp.get(i-1).get(j));
            }
            dp.add(row);
        }
        return dp.get(rowIndex);
    }

    public static void main(String[] args) {
        _0119 Sol = new _0119();
        List<Integer> res = Sol.getRow(3);
        System.out.println(res);
    }
}
