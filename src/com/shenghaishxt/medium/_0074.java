package com.shenghaishxt.medium;

public class _0074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;
        for (int[] row : matrix) {
            if (target <= row[matrix[0].length - 1]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (target == row[j])
                        return true;
                }
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new _0074().searchMatrix(new int[][] {{0,1,2,0}, {3,4,5,2}, {1,3,1,5}}, 5));
    }
}
