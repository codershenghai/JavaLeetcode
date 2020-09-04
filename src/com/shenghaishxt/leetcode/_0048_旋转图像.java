package com.shenghaishxt.leetcode;

public class _0048_旋转图像 {
    private static void rotate(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        // 转置
        for (int i = 0; i < m; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // 每行都进行翻转
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
