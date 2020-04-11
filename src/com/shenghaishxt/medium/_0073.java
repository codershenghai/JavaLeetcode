package com.shenghaishxt.medium;

import java.util.ArrayList;
import java.util.List;

public class _0073 {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return;
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    lists.add(list);
                }
            }
        }
        for (List<Integer> list : lists) {
            helper(matrix, list.get(0), list.get(1));
        }
    }

    public void helper(int[][] matrix, int row, int col) {
        // 保持行不动，处理列
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = 0;
        }
        // 保持列不动，处理行
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][col] = 0;
        }
    }

    public static void main(String[] args) {
        new _0073().setZeroes(new int[][] {{1,1,1}, {1,0,1}, {1,1,1}});
        new _0073().setZeroes(new int[][] {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}});
    }
}
