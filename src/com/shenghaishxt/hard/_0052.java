package com.shenghaishxt.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于所有列有 列 = 常数
 * 对于所有的主对角线有 行号 + 列号 = 常数
 * 对于所有的次对角线有 行号 - 列号 = 常数
 *
 * 回溯算法的框架：
 * result = []
 * def backtrack(路径, 选择列表):
 *     if 满足结束条件:
 *         result.add(路径)
 *         return
 *
 *     for 选择 in 选择列表:
 *         (剪枝)
 *         做选择
 *         backtrack(路径, 选择列表)
 *         撤销选择
 */
public class _0052 {
    private int count = 0;

    private int totalNQueens(int n) {
        // 初始化
        boolean[] rows = new boolean[n];
        boolean[] hills = new boolean[4 * n - 1];  // 主对角线
        boolean[] dales = new boolean[2 * n - 1];  // 副对角线

        // 开始回溯
        backTrack(0, n, rows, hills, dales);
        return count;
    }

    private void backTrack(int row, int n, boolean[] rows, boolean[] hills, boolean[] dales) {
        // 递归结束的条件
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            // 剪枝
            if (rows[col] || hills[row - col + 2 * n] || dales[row + col])
                continue;

            // 做选择
            rows[col] = true;
            hills[row - col + 2 * n] = true;
            dales[row + col] = true;

            // backtrack
            backTrack(row + 1, n, rows, hills, dales);

            // 撤销选择
            rows[col] = false;
            hills[row - col + 2 * n] = false;
            dales[row + col] = false;
        }
    }

    public static void main(String[] args) {
        _0052 Sol = new _0052();
        int n = 8;
        System.out.println(Sol.totalNQueens(n));
    }
}
