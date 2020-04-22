package com.shenghaishxt.hard;


import java.util.ArrayList;
import java.util.List;

public class _0051 {
    /**
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

    // 初始化一个棋盘，然后尝试对每一行设置皇后，将可行解存到res中
    private List<List<String>> res = new ArrayList<>();

    private List<List<String>> solveNQueens(int n) {
        // 首先初始化棋盘
        List<StringBuilder> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(".".repeat(n));
            board.add(sb);
        }

        // 开始回溯
        backTrack(board, 0);
        return res;
    }

    private void backTrack(List<StringBuilder> board, int row) {
        // 递归结束的条件
        if (row == board.size()) {
            List<String> tmp = new ArrayList<>();
            for (StringBuilder i : board)
                tmp.add(i.toString());
            res.add(tmp);
            return;
        }
        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 剪枝
            if (!isValid(board, row, col))
                continue;

            // 做选择
            board.get(row).setCharAt(col, 'Q');

            // backtrack
            backTrack(board, row+1);

            // 撤销选择
            board.get(row).setCharAt(col, '.');
        }
    }

    private boolean isValid(List<StringBuilder> board, int row, int col) {

        // 检查列是否有皇后冲突
        for (StringBuilder stringBuilder : board) {
            if (stringBuilder.charAt(col) == 'Q')
                return false;
        }

        // 检查左上方是否有皇后冲突
        for (int i=row-1, j=col-1; i>=0 && j>=0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q')
                return false;
        }

        // 检查右上方是否有皇后冲突
        for (int i=row-1, j=col+1; i>=0 && j<board.size(); i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _0051 Sol = new _0051();
        int n = 8;
        List<List<String>> res = Sol.solveNQueens(n);
        System.out.println(res);
    }
}
