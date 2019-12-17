package com.shenghaishxt.easy;

import java.util.ArrayList;
import java.util.List;

public class _0118 {
    private List<List<Integer>> generate(int numRows) {
        List<List<Integer>> dp = new ArrayList<>();

        // dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else row.add(dp.get(i-1).get(j-1) + dp.get(i-1).get(j));
            }
            dp.add(row);
        }
        return dp;
    }

    public static void main(String[] args) {
        _0118 Sol = new _0118();
        List<List<Integer>> res = Sol.generate(5);
        System.out.println(res);
    }
}
